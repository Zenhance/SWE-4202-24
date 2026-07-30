package kenakata.exceptions;

public class ReturnedNotAllowedException extends CheckoutException{
    public ReturnedNotAllowedException(String message){
        super(message);
    }
}
