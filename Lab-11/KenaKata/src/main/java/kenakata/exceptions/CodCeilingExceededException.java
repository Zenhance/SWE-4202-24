package kenakata.exceptions;

public class CodCeilingExceededException extends PaymentDeclinedException {

    public CodCeilingExceededException() {
        super("Cash on delivery limit exceeded.");
    }
}
