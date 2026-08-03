package kenakata.exceptions;

public class CouponRejectedException extends CheckoutException {
    public CouponRejectedException(String msg) {
        super(msg);
    }
}
