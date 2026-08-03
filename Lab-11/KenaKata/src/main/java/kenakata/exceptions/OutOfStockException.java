package kenakata.exceptions;

public class OutOfStockException extends CheckoutException {

    public OutOfStockException(String msg) {
        super(msg);
    }
}
