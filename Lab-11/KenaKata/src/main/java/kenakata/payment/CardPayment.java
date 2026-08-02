package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public final class CardPayment implements PaymentMethod {

    private long remainingLimit;

    public CardPayment(long limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("");
        }
        this.remainingLimit = limit;
    }

    public long remainingLimit() {
        return remainingLimit;
    }

    @Override
    public void authorise(long amount) throws CardLimitExceededException {
        if (amount > remainingLimit) {
            throw new CardLimitExceededException("");
        }
        remainingLimit -= amount;
    }
}
