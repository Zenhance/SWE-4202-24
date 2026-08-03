package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final double percentage;
    private final long maxDiscount;
    private final long minSpend;
    private final int lastValidDay; // coupon's last validity
    public Coupon(String code,double percentage,long maxDiscount,long minSpeed, int lastValidDay){
        if(percentage<0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }
        this.code=code;
        this.percentage = percentage;
        this.maxDiscount= maxDiscount;
        this.minSpend= minSpeed;
        this.lastValidDay = lastValidDay;
        }
        public String code(){

        return code;
    }
        public long calculateDiscount(long discountableBase, int currentDay) throws CouponRejectedException{
        if(currentDay > lastValidDay){
            throw new CouponRejectedException("Coupon has expired");
        }
        if(discountableBase < minSpend){
            throw new CouponRejectedException("Order subtotal below minimum spend required for coupon");
        }
        long discount = (long) Math.ceil(discountableBase*(percentage/100.0));
        return Math.min(discount,maxDiscount);
    }
}
