package kenakata.exceptions;

public class NotInsurableException extends CheckoutException{
    public NotInsurableException(String message){
        super("This line cannot be insured");
    }
}
