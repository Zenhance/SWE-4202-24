package kenakata.exceptions;

public class OutOfStockException extends CheckoutException {
    public OutOfStockException(String message, int quantity, int stock) {
        super(message);
    }
}
