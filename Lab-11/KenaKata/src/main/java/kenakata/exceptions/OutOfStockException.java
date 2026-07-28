package kenakata.exceptions;

public class OutOfStockException extends CheckoutException{
    public OutOfStockException(){
        super("Item is out of stock");
    }
}
