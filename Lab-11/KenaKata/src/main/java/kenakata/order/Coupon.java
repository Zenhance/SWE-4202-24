package kenakata.order;
import kenakata.catalog.MoneyMath;
import kenakata.exceptions.CouponRejectedException;

public final class Coupon {
    private final String code;
    private final int percentage;
    private final long cap;
    private final long minimumSpeed;
    private final int lastValidDay;

    public Coupon(String ode, int percentage, long cap, long minimumSpeed, int lastValidDay){
        if(code == null || code.isBlank()){
            throw new IllegalArgumentException("Coupn percentage must be between 0 and 100");
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
}
