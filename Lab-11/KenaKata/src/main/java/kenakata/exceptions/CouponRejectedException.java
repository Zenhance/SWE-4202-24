package kenakata.exceptions;

public class CouponRejectedException extends RuntimeException {
    public CouponRejectedException(String message) {
        super(message);
    }
}
