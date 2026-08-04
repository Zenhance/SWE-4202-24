package kenakata.exceptions;

public class CodCeilingExceededException extends PaymentDeclinedException {
    public CodCeilingExceededException(String msg) {
        super(msg);
    }
}
