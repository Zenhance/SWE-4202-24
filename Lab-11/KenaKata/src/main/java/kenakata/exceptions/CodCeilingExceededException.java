package kenakata.exceptions;

public class CodCeilingExceededException extends PaymentException{
    public CodCeilingExceededException(String msg) {
        super(msg);
    }
}
