package kenakata;

public class CodCeilingExceededException extends PaymentDeclinedException{
    CodCeilingExceededException(String message){
        super(message);
    }
}
