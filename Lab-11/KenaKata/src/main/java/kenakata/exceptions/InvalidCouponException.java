package kenakata.exceptions;

public class InvalidCouponException extends CheckoutException {
    public InvalidCouponException(String message) {
        super(message);
    }
}