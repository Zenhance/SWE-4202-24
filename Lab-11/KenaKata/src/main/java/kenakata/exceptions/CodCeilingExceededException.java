package main.java.kenakata.exceptions;

public class CodCeilingExceededException extends PaymentDeclinedException{
    public CodCeilingExceededException(String message){
        super(message);
    }
}
