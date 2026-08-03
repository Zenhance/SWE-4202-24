package kenakata.order;

import kenakata.exceptions.InvalidCouponException;

public class Coupon {
    private String code;
    private int percentage;
    private long cap;
    private long minSpend;
    private int lastValidDay;

    public Coupon(String code, int percentage, long cap, long minSpend, int lastValidDay) {
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minSpend = minSpend;
        this.lastValidDay = lastValidDay;
    }
}