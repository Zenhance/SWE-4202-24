package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final int percent;

    public Coupon(String code, int percent) {
        this.code = code;
        this.percent = percent;
    }

    public long discount(long amount, int day){
        return 0;
    }

    public String code() {
        return code;
    }

    public int percent() {
        return percent;
    }


}