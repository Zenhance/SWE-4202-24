package kenakata.order;

import kenakata.catalog.Money;
import kenakata.exceptions.CouponRejectedException;

public class Coupon {

    private final String code;
    private final long percent;
    private final long cap;
    private final long minSpend;
    private final long validThroughDay;

    public Coupon(String code, long percent, long cap, long minSpend, long validThroughDay) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("code must not be blank");
        }
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("percent must be between 0 and 100");
        }
        if (cap < 0) {
            throw new IllegalArgumentException("cap must be >= 0");
        }
        if (minSpend < 0) {
            throw new IllegalArgumentException("minSpend must be >= 0");
        }
        this.code = code;
        this.percent = percent;
        this.cap = cap;
        this.minSpend = minSpend;
        this.validThroughDay = validThroughDay;
    }

    public String code() {
        return code;
    }

    public long apply(long discountableBase, long subtotal, long day) throws CouponRejectedException {
        if (day > validThroughDay) {
            throw new CouponRejectedException("Coupon " + code + " expired on day " + validThroughDay);
        }
        if (subtotal < minSpend) {
            throw new CouponRejectedException("Coupon " + code + " requires a minimum spend of " + minSpend);
        }
        long raw = Money.ceilPercent(discountableBase, percent * 10);
        return Math.min(raw, cap);
    }
}