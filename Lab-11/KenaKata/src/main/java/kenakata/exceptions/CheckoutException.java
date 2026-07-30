package main.java.kenakata.exceptions;

/**
 * Base checked exception for business refusals in the KenaKata engine.
 */
public class CheckoutException extends Exception {
    public CheckoutException(String message) {
        super(message);
    }
}
