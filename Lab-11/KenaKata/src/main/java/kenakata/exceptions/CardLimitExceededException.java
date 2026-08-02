package kenakata.exceptions;

public class CardLimitExceededException extends PaymentDeclineException {
    public CardLimitExceededException(String message) {
        super(message);
    }
}
