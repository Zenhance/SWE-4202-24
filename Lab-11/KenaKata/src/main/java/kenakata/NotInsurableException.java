package kenakata;

public class NotInsurableException extends CheckoutException{
    public NotInsurableException(String message){
        super(message);
    }
}
