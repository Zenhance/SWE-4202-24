package kenakata.order;

import kenakata.exceptions.InvalidCouponException;

public class Coupon {
    private String code;
    private int percentage;
    private long cap;
    private long minSpend;
    private int lastValidDay;

    public Coupon(String code, int percentage, long cap, long minSpend, int lastValidDay) {
        if (code == null || code.isBlank() || percentage < 0 || percentage > 100 || cap < 0 || minSpend < 0 || lastValidDay < 0) {
            throw new IllegalArgumentException("Invalid coupon arguments");
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

    public long calculateDiscount(long discountableBase, int currentDay) throws InvalidCouponException {
        if (currentDay > lastValidDay) {
            throw new InvalidCouponException("Coupon expired");
        }
        if (discountableBase < minSpend) {
            throw new InvalidCouponException("Order base below minimum spend requirement");
        }
        long discount = (long) Math.ceil(discountableBase * (percentage / 100.0));
        return Math.min(discount, cap);
    }
}