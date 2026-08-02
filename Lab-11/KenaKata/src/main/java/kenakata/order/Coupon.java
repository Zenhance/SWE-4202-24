package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private String code;
    private int percentage;
    private long cap;
    private long minimumSpend;
    private int lastValidDay;

    public Coupon(String code, int percentage, long cap, long minimumSpend, int lastValidDay) {
        if(code==null||code.isEmpty()){
            throw new IllegalArgumentException("coupon code cannot be null or empty");
        }
        if(percentage<0||percentage>100){
            throw new IllegalArgumentException("coupon percentage must be between 0 and 100");
        }
        if(cap<0){
            throw new IllegalArgumentException("coupon capacity cannot be negative");
        }
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.lastValidDay = lastValidDay;
    }
    public String code() {
        return code;
    }

    public long discountFor(long subtotal, long discountableBase, int today)throws CouponRejectedException {
        if(today<lastValidDay){
            throw new CouponRejectedException("Coupon"+code+"expired on day "+lastValidDay);
        }
        if(subtotal<minimumSpend){
            throw new CouponRejectedException("Coupon " + code + " needs a minimum spend of " + minimumSpend + ", order is " + subtotal);
        }
        long raw = (long) Math.ceil(discountableBase * percentage / 100.0);
        return Math.min(raw, cap);
    }
}
