package kenakata.exceptions;

public class OutOfStockException extends CheckOutException {
    public OutOfStockException(String message){
        super(message);
    }
}
