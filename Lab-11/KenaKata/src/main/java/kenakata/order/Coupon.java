package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final long percent;
    private final long cap;
    private final long minSpend;
    private final int validDays;

    public Coupon(String code, long percent, long cap, long minSpend, int validDays) {
        if (percent < 0 || percent > 100) throw new IllegalArgumentException("Invalid percentage");
        this.code = code;
        this.percent = percent;
        this.cap = cap;
        this.minSpend = minSpend;
        this.validDays = validDays;
    }

    public String code() { return code; }

    public long discount(long discountableBase, long subtotal, int today) throws CouponRejectedException {
        if (today > validDays) throw new CouponRejectedException("Coupon expired");
        if (subtotal < minSpend) throw new CouponRejectedException("Minimum spend not met");

        long calculated = (long) Math.ceil(discountableBase * (percent / 100.0));
        return Math.min(calculated, cap);
    }
}