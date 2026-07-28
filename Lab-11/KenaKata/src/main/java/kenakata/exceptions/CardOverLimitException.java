package kenakata.exceptions;

public class CardOverLimitException extends PaymentException{
    public CardOverLimitException(String msg) {
        super(msg);
    }
}
