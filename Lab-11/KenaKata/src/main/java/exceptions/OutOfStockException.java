package kenakata.exceptions;

/** An item did not have enough stock remaining to satisfy a reservation. */
public class OutOfStockException extends CheckoutException {

    public OutOfStockException(String message) {
        super(message);
    }
}
