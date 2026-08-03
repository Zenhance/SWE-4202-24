package kenakata.exceptions;

/** A card's remaining limit was too low to authorise the requested amount. */
public class CardLimitExceededException extends PaymentDeclinedException {

    public CardLimitExceededException(String message) {
        super(message);
    }
}
