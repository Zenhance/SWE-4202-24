package kenakata.order;

import kenakata.exceptions.CouponRejectedException;
public class Coupon {
    private final String code;
    private final int percentage;
    private final long cap;
    private final long minimumSpend;
    private final int lastValidDay;

    public Coupon(String code,int percentage,long cap,long minimumSpend,int lastValidDay){
        if(code == null || code.isBlank() || percentage < 0 || percentage > 100 || cap < 0 || minimumSpend < 0 || lastValidDay < 0){
            throw new IllegalArgumentException("Invalid coupon");
        }
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.lastValidDay = lastValidDay;
    }

    public String code(){
        return code;
    }

    public long discount(long discountableBase, int today)
            throws CouponRejectedException {

        if(today > lastValidDay){
            throw new CouponRejectedException("Coupon expired");
        }

        if(discountableBase < minimumSpend){
            throw new CouponRejectedException("Minimum spend not reached");
        }

        long result = (discountableBase * percentage + 99) / 100;

        return Math.min(result, cap);
    }

}