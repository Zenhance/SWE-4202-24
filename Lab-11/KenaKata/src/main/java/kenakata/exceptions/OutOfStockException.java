package kenakata.exceptions;

public class OutOfStockException extends CheckoutException {

    public OutOfStockException() {
        super("Out of stock");
    }

    public OutOfStockException(String message) {
        super(message);
    }
}