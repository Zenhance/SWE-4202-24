package kenakata.exception;

public class CouponException extends BusinessException {

    public CouponException(String message) {
        super(message);
    }

    public CouponException(
            String message,
            Throwable cause
    ) {
        super(message, cause);
    }
}