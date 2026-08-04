package kenakata.exception;

public class CouponExpiredException extends CouponException {

    public CouponExpiredException(String message) {
        super(message);
    }

    public CouponExpiredException(
            String message,
            Throwable cause
    ) {
        super(message, cause);
    }
}