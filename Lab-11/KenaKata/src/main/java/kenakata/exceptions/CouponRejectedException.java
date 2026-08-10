package main.java.kenakata.exceptions;

public class CouponRejectedException extends CheckoutException{
    public CouponRejectedException(String message){
        super(message);
    }
}
