package kenakata.exceptions;

public class OutofStockException extends CheckoutException{

    public OutofStockException(String message){
        super(message);
    }
}
