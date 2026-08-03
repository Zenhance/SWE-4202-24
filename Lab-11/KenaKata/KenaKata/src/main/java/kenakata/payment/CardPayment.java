package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public final class CardPayment implements PaymentMethod {
    private long remainingLimit;

    public CardPayment(long limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Card limit cannot be negative");
        }
        this.remainingLimit = limit;
    }

    public long remainingLimit() {
        return remainingLimit;
    }

    @Override
    public void validate(long amount) throws CardLimitExceededException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (amount > remainingLimit) {
            throw new CardLimitExceededException("Card limit exceeded");
        }
    }

    @Override
    public void authorise(long amount) throws CardLimitExceededException {
        validate(amount);
        remainingLimit -= amount;
    }
}
