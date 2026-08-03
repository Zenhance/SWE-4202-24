package kenakata.exceptions;

public class CODLimitExceededException extends PaymentException{
    CODLimitExceededException(String message){
        super(message);
    }
}
