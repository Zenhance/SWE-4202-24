package kenakata.exceptions;

public class OutOfStockException extends CheckOutExceptions{
    public OutOfStockException(){
        super("Out of Stock");
    }
}
