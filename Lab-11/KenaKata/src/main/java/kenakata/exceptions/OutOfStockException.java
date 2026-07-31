package kenakata.exceptions;

public class OutOfStockException extends CheckoutException {
    public OutOfStockException(){
        super("Out of Stock");
    }
}
