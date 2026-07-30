package kenakata.exceptions;

public class CodCeilingException extends PaymentDeclinedException{
    public CodCeilingException(String message){
        super("Cash on delivery limit exceeded.");
    }
}
