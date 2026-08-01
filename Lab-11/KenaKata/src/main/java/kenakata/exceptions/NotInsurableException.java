package kenakata.exceptions;

public class NotInsurableException extends CheckoutException{
    public NotInsurableException(){
        super("This line cannot be insured");
    }

    public NotInsurableException(String message){
        super(message);
    }
}
