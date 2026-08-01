package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private String code;
    private long percentage;
    private long cap;
    private long minimumSpend;
    private int lastValidDay;

    public Coupon(String code, long percentage, long cap, long minimumSpend, int lastValidDay) {
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.lastValidDay = lastValidDay;
    }

    public String code() {
        return code;
    }

    public long percentage() {
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

}
