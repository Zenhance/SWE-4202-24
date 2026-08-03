package kenakata.exceptions;

public class CODLimitExceededException extends PaymentDeclinedException {
    public CODLimitExceededException(String message){
        super(message);
    }
}
