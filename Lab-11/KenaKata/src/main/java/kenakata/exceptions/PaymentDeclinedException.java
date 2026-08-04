package kenakata.exceptions;

public class PaymentDeclinedException extends CheckoutException {

    protected PaymentDeclinedException(String message) {
        super(message);
    }
}
