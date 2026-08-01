package kenakata.exceptions;

public class PaymentDeclinedException extends CheckoutException {
    public PaymentDeclinedException(){
        super();
    }
    public PaymentDeclinedException(String message){
        super(message);
    }
}
