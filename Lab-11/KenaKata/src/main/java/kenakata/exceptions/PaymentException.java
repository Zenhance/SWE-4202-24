package kenakata.exceptions;

public class PaymentException extends CheckoutException {
    public PaymentException(String msg) {
        super(msg);
    }
}
