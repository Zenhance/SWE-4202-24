package kenakata.order;

import kenakata.exceptions.CouponRejectedException;


public final class Coupon {

    private final String code;
    private final int percent;
    private final long cap;
    private final long minSpend;
    private final int lastValidDay;

    public Coupon(String code, int percent, long cap, long minSpend, int lastValidDay) {
        this.code = code;
        this.percent = percent;
        this.cap = cap;
        this.minSpend = minSpend;
        this.lastValidDay = lastValidDay;
    }

    public String code() {
        return code;
    }

}
