package kenakata.exceptions;

/** A coupon was invalid for the order it was applied to: expired, or below its minimum spend. */
public class CouponRejectedException extends CheckoutException {

    public CouponRejectedException(String message) {
        super(message);
    }
}
