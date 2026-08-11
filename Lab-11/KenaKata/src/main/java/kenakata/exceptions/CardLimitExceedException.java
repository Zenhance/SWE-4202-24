package kenakata.exceptions;

public class CardLimitExceedException extends CheckoutException {
    public CardLimitExceedException(String message) {
        super(message);
    }
}
