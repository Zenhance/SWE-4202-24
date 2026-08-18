package kenakata.exceptions;

public class CodCeilingExceededException extends PaymentDeclinedException {

    public CodCeilingExceededException() {
        super("COD ceiling exceeded");
    }
}