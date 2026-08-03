package kenakata.exceptions;

public abstract class CheckoutException extends Exception {

    protected CheckoutException(String message) {
        super(message);
    }
}