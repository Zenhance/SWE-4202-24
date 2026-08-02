package kenakata.exceptions;

public class CodCeilingExceededException extends PaymentDeclineException {
    public CodCeilingExceededException(String message) {
        super(message);
    }
}
