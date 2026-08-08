package kenakata.exceptions;

public class CardLimitException extends PaymentException {
    public CardLimitException(String message){
        super(message);
    }
}
