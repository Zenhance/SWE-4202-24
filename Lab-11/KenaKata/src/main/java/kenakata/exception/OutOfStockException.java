package kenakata.exception;

public class OutOfStockException extends CheckoutException {
    public OutOfStockException(){
        super("Not enough stock");
    }

}
