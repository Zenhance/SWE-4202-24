package kenakata.exceptions;

public class OutOfStockException extends BusinessException{
    public OutOfStockException(String message){
        super(message);
    }
}
