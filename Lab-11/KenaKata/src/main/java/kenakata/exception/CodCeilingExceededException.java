package kenakata.exception;

public class CodCeilingExceededException extends PaymentDeclinedException{
    public CodCeilingExceededException(String message) {
        super(message);
    }
}
