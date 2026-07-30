package kenakata.exceptions;

public class InvalidOrderException extends CheckoutException{
    public InvalidOrderException(String message){
        super(message);
    }
}
