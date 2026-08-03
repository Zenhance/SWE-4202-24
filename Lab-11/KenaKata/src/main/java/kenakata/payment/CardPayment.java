package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public class CardPayment implements PaymentMethod {
    private long limit;

    public CardPayment(long limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit cannot be negative");
        }
        this.limit = limit;
    }

    public long remainingLimit() {
        return limit;
    }

    @Override
    public void authorise(long amount) throws CardLimitExceededException {
        if (amount > limit) {
            throw new CardLimitExceededException("Card limit exceeded");
        }
        limit -= amount;
    }
}