package kenakata.order;
import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final int percentage;
    private final long maxDiscount;
    private final int expiryDay;
    private final long minSpend;
    public Coupon(String code,int percentage,long maxDiscount,long minSpend,int expiryDay){
        if(percentage<0||percentage>100){
            throw new IllegalArgumentException("Percentage must be between 0-100");
        }
        this.code=code;
        this.percentage=percentage;
        this.maxDiscount=maxDiscount;
        this.minSpend=minSpend;
        this.expiryDay=expiryDay;
    }
    public void validate(long subtotal,int currentDay)throws CouponRejectedException{
        if(currentDay>expiryDay){
            throw new CouponRejectedException("Coupon expired");
        }
        if(subtotal<minSpend){
            throw new CouponRejectedException("Minimum spend requirement not met");
        }
    }
    public long calculateDiscount(long discountableBase){
        long calculated=(long)Math.ceil(discountableBase*(percentage/100.0));
        return Math.min(calculated,maxDiscount);
    }
}
