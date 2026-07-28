package kenakata.exceptions;

public abstract class PaymentDeclinedException extends CheckoutException{
    public PaymentDeclinedException(String message){
        super(message);
    }

}
