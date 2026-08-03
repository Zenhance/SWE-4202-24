package kenakata.exception;

public class PaymentDeclinedException extends CheckoutException{
    public PaymentDeclinedException(String message){
        super(message);

    }
}
