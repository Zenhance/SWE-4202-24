package kenakata.exception;

public class CardLimitExceededException extends PaymentDeclinedException{
    public CardLimitExceededException(String message){
        super(message);

    }
}
