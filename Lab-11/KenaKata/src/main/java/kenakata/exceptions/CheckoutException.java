package kenakata.exceptions;

public class CheckoutException extends Exception{
    public CheckoutException(String message) {
        super(message);
    }
    public CheckoutException() {
        super();
    }
}
