package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private String code;
    private long percentage;
    private long cap;
    private long minimumSpend;
    private int lastValidDay;

    public Coupon(String code, long percentage, long cap, long minimumSpend, int lastValidDay) {
        if(code==null || code.isEmpty()) throw new IllegalArgumentException("Coupon code can't be empty");
        if(percentage<0 || percentage>100) throw new IllegalArgumentException("Percentage must be between 0 and 100");
        if(cap<=0) throw new IllegalArgumentException("Cap can't be negative or zero");
        if(minimumSpend<0) throw new IllegalArgumentException("Minimum spend can't be negative");
        if(lastValidDay<0) throw new IllegalArgumentException("Last valid day can't be negative");

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
