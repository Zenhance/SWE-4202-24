package kenakata.exception;

public class CardLimitExceededException
        extends PaymentException {

    public CardLimitExceededException(String message) {
        super(message);
    }

    public CardLimitExceededException(
            String message,
            Throwable cause
    ) {
        super(message, cause);
    }
}
