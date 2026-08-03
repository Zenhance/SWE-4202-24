package kenakata.exceptions;

public class CardLimitExceededException extends CheckoutException {
    public CardLimitExceededException(String message){
        super(message);
    }
}
