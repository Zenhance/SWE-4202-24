package kenakata.exceptions;

public class CardLimitExceedException extends PaymentDeclinedException{
    public CardLimitExceedException(String message){
        super(message);
    }
}
