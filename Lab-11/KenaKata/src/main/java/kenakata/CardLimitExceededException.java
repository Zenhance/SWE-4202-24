package kenakata;

public class CardLimitExceededException extends CheckoutException{
    public CardLimitExceededException(String message){
        super(message);
    }
}
