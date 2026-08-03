package kenakata.exceptions;

public class CardLimitExceededException extends PaymentException{
    public CardLimitExceededException(String msg) {
        super(msg);
    }
}
