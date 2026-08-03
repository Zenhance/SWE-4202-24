package kenakata.exceptions;

public class CardLimitExceededException extends PaymentException{
    CardLimitExceededException(String message){
        super(message);
    }
}
