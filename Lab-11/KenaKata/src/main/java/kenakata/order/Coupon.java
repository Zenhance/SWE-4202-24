package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String couponCode;
    private final long percentage;
    private final long cap;
    private final long minSpend;
    private final long validDays;

    public Coupon(String couponCode, long percentage, long cap, long minSpend, long validDays) {
        if(couponCode == null || couponCode.isEmpty()) {throw new IllegalArgumentException("couponCode is not valid");}
        if(percentage<0 || percentage>100) {throw new IllegalArgumentException("Invalid percentage");}
        this.couponCode = couponCode;
        this.percentage = percentage;
        this.cap = cap;
        this.minSpend = minSpend;
        this.validDays = validDays;
    }

    public String couponCode() {return couponCode;}
    public long getPercentage() {return this.percentage;}

    public long discount(long discountableBase,int today) throws CouponRejectedException {
        if(today>validDays) {throw new CouponRejectedException("Coupon has been expired");}
        if(discountableBase<minSpend) {throw new CouponRejectedException("minimum spend not met");}

        long discount = (long) Math.ceil(discountableBase * (percentage / 100.0));
        return Math.min(discount, cap);
    }


}
