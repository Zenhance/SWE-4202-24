package kenakata.exception;

public class CouponRejectedException extends CheckoutException{
    public CouponRejectedException(String message){
        super(message);

    }
}
