package kenakata.exceptions;

/** A customer tried to insure a line that does not carry that capability. */
public class NotInsurableException extends CheckoutException {

    public NotInsurableException(String message) {
        super(message);
    }
}
