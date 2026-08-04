package kenakata.exceptions;

public final class CouponRejectedException extends CheckoutException {

    public CouponRejectedException(String message) {
        super(message);
    }
}
