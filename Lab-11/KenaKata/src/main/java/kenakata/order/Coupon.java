package kenakata.order;

import kenakata.catalog.MoneyMath;
import kenakata.exceptions.CouponRejectedException;

public final class Coupon {

    private final String code;
    private final int percent;
    private final long cap;
    private final long minimumSpend;
    private final int lastValidDay;

    public Coupon(String code, int percent, long cap, long minimumSpend, int lastValidDay) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Code must not be null or blank");
        }
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Percent must be between 0 and 100");
        }
        this.code = code;
        this.percent = percent;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.lastValidDay = lastValidDay;
    }

    public String code() {
        return code;
    }

    public long discount(long discountableBase, int today) throws CouponRejectedException {
        if (today > lastValidDay) {
            throw new CouponRejectedException("Coupon " + code + " expired on day " + lastValidDay);
        }
        if (discountableBase < minimumSpend) {
            throw new CouponRejectedException("Coupon " + code + " requires a minimum spend of " + minimumSpend);
        }
        long amount = MoneyMath.ceilPercentage(discountableBase, percent);
        return Math.min(amount, cap);
    }
}
