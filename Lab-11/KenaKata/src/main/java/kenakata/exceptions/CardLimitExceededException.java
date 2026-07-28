package kenakata.exceptions;

public class CardLimitExceededException extends Exception {
    public CardLimitExceededException(String message) {
        super(message);
    }
}
