package kenakata.order;

import kenakata.catalog.MoneyMath;
import kenakata.exceptions.CouponRejectedException;

public final class Coupon {
    private final String code;
    private final int percentage;
    private final long cap;
    private final long minimumSpend;
    private final int lastValidDay;

    public Coupon(String code, int percentage, long cap, long minimumSpend, int lastValidDay) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Coupon code is required");
        }
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Coupon percentage must be from 0 to 100");
        }
        if (cap < 0 || minimumSpend < 0 || lastValidDay < 0) {
            throw new IllegalArgumentException("Coupon values cannot be negative");
        }
        this.code = code.trim();
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.lastValidDay = lastValidDay;
    }

    public String code() {
        return code;
    }

    public int percentage() {
        return percentage;
    }

    public long cap() {
        return cap;
    }

    public long minimumSpend() {
        return minimumSpend;
    }

    public int lastValidDay() {
        return lastValidDay;
    }

    public long discount(long discountableBase, long orderSubtotal, int currentDay)
            throws CouponRejectedException {
        if (discountableBase < 0 || orderSubtotal < 0 || currentDay < 0) {
            throw new IllegalArgumentException("Discount inputs cannot be negative");
        }
        if (currentDay > lastValidDay) {
            throw new CouponRejectedException("Coupon " + code + " has expired");
        }
        if (orderSubtotal < minimumSpend) {
            throw new CouponRejectedException("Minimum spend not reached for coupon " + code);
        }
        return Math.min(cap, MoneyMath.ceilRate(discountableBase, percentage, 100));
    }

    public long computeDiscount(long discountableBase, long orderSubtotal, int currentDay)
            throws CouponRejectedException {
        return discount(discountableBase, orderSubtotal, currentDay);
    }

    public long discount(long discountableBase, int currentDay) throws CouponRejectedException {
        return discount(discountableBase, discountableBase, currentDay);
    }
}
