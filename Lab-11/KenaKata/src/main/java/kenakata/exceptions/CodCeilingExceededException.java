package kenakata.exceptions;

/** The amount to be paid on delivery exceeded the cash-on-delivery ceiling. */
public class CodCeilingExceededException extends PaymentDeclinedException {

    public CodCeilingExceededException(String message) {
        super(message);
    }
}
