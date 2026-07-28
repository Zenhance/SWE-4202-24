package exceptions;

public class OutOfStockException extends CheckoutException {
    public OutOfStockException(String message) {
        super(message);
    }
}
