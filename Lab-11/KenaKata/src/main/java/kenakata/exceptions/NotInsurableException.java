package kenakata.exceptions;

public class NotInsurableException extends CouponRejectedException{
    NotInsurableException(String message){
        super(message);
    }
}
