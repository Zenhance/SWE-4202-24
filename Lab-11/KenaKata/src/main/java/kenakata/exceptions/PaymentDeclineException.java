package kenakata.exceptions;

public class PaymentDeclineException extends CheckoutException{
    public PaymentDeclineException(String message) {
        super(message);
    }
}
