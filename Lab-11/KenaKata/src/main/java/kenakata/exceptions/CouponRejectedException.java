package kenakata.exceptions;

public class CouponRejectedException extends CheckoutException {

    public CouponRejectedException() {
        super("Coupon rejected");
    }
}