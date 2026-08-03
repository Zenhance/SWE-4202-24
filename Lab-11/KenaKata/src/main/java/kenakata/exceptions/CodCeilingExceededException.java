package kenakata.exceptions;

public class CodCeilingExceededException extends PaymentDeclinedException{
    public CodCeilingExceededException(){
        super();
    }
    public CodCeilingExceededException(String message){
        super(message);
    }
}