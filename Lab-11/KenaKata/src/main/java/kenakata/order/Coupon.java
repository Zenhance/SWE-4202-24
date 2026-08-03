package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public final class Coupon {

    private final String code;
    private final int percent;
    private final long cap;
    private final long minimumSpend;
    private final long lastValidDay;

    public Coupon(String code, int percent, long cap, long minimumSpend, long lastValidDay) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Coupon code cannot be blank");
        }
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Coupon percent must be between 0 and 100");
        }
        if (cap < 0) {
            throw new IllegalArgumentException("Coupon cap cannot be negative");
        }
        if (minimumSpend < 0) {
            throw new IllegalArgumentException("Minimum spend cannot be negative");
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

    /** The discount for a discountable base, given the order's subtotal and the current
     * day. Refuses if expired or if the subtotal is below the minimum spend. */
    public long discountFor(long subtotal, long discountableBase, long day)
            throws CouponRejectedException {
        if (day > lastValidDay) {
            throw new CouponRejectedException("Coupon " + code + " expired on day " + lastValidDay);
        }
        if (subtotal < minimumSpend) {
            throw new CouponRejectedException(
                    "Coupon " + code + " requires a minimum spend of Tk " + minimumSpend);
        }
        long raw = (long) Math.ceil(discountableBase* percent);
        return Math.min(raw, cap);
    }
}
