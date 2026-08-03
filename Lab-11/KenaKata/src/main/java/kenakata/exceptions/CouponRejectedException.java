package kenakata.exceptions;

public class CouponRejectedException extends BusinessException{
    CouponRejectedException(String message){
        super(message);
    }
}
