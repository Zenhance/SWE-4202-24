package kenakata.order;
import kenakata.catalog.MoneyMath;
import kenakata.exceptions.CouponRejectedException;

public final class Coupon {
    private final String code;
    private final int percentage;
    private final long cap;
    private final long minimumSpeed;
    private final int lastValidDay;

    public Coupon(String code, int percentage, long cap, long minimumSpeed, int lastValidDay){
        if(code == null || code.isBlank()){
            throw new IllegalArgumentException("Coupon percentage must be between 0 and 100");
        }
        if (percentage < 0 || percentage > 100) {
        throw new IllegalArgumentException("Coupon percentage must be between 0 and 100");
        }
        if(cap<0 || minimumSpeed<0 || lastValidDay<0){
            throw new IllegalArgumentException("Coupon limits cannot be negative");
        }
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpeed = minimumSpeed;
        this.lastValidDay = lastValidDay;
    }
    public String code(){
        return code;
    }
    public int percentage(){
        return percentage;
    }
    public long cap(){
        return cap;
    }
    public long minimumSpeed(){
        return minimumSpeed;
    }
    public int getLastValidDay(){
        return lastValidDay;
    }
    public long discountFor(long discountableBase, long subtotal, int currentDay) throws CouponRejectedException{
        if(discountableBase<0 || subtotal<0 || currentDay<0){
            throw new IllegalArgumentException("Pricing inputs cannot be negative");
        }
        if(currentDay>lastValidDay){
            throw new CouponRejectedException("Coupon "+code+" has expired");
        }
        if(subtotal<minimumSpeed){
            throw new CouponRejectedException("Coupon "+code+" requires a minimum spend of Tk "+minimumSpeed);
        }
        long calculatedDiscount = MoneyMath.ceilPercent(discountableBase,percentage);
        return Math.min(cap,calculatedDiscount);
    }
    public long discountFor(long discountableBase, int currentDay) throws CouponRejectedException{
        return discountFor(discountableBase,discountableBase,currentDay);
    }
}
