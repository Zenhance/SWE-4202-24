package kenakata.exceptions;

public class CardLimitExceededException extends PaymentDeclinedException {
    public CardLimitExceededException(String msg) {
        super(msg);
    }
}
