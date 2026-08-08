package kenakata.exceptions;

public class CODLimitException extends PaymentException{
    public CODLimitException(String message){
        super(message);
    }
}
