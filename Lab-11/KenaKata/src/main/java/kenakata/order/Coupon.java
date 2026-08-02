package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final int pct;
    private final long cap;
    private final long minSpeed;
    private final int expiryDay;

    public Coupon(String code, int pct, long cap, long minSpeed, int expiryDay) {
        this.code = code;
        this.pct = pct;
        this.cap = cap;
        this.minSpeed = minSpeed;
        this.expiryDay = expiryDay;
    }

    public String code() {
        return code;
    }

    public long calculateDiscount()
}
