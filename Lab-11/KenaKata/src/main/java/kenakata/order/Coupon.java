package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final int percentage;
    private final long cap;
    private final long minimumSpend;
    private final int lastValidDay;

    public Coupon(String code, int percentage, long cap, long minimumSpend, int lastValidDay) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Coupon percentage must be between 0 and 100.");
        }

        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.lastValidDay = lastValidDay;
    }

    public long discount(long discountableBase, int today) throws CouponRejectedException {
        if (today > lastValidDay) {
            throw new CouponRejectedException();
        }

        if (discountableBase < minimumSpend) {
            throw new CouponRejectedException();
        }

        long calculated = (long) Math.ceil(discountableBase * percentage / 100.0);

        return Math.min(calculated, cap);
    }
}
