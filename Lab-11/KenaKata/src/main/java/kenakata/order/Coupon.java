package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final int percentage;
    private final long cap;
    private final long minSpend;
    private final int lastValidDay;

    public Coupon(String code, int percentage, long cap, long minSpend, int lastValidDay) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Coupon percentage must be between 0 and 100");
        }
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minSpend = minSpend;
        this.lastValidDay = lastValidDay;
    }

    public String code() {
        return code;
    }

    public long calculateDiscount(long discountableBase, long subtotal, int currentDay) throws CouponRejectedException {
        if (currentDay > lastValidDay) {
            throw new CouponRejectedException();
        }
        if (subtotal < minSpend) {
            throw new CouponRejectedException();
        }
        long discount = (long) Math.ceil(discountableBase * (percentage / 100.0));
        return Math.min(discount, cap);
    }
}
