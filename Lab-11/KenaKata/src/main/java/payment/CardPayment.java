package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

/** Pays by card; succeeds unless the amount exceeds the card's remaining limit. */
public final class CardPayment implements PaymentMethod {

    private long remainingLimit;

    public CardPayment(long limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit must not be negative");
        }
        this.remainingLimit = limit;
    }

    @Override
    public void authorise(long amount) throws CardLimitExceededException {
        if (amount > remainingLimit) {
            throw new CardLimitExceededException(
                    "amount " + amount + " exceeds remaining limit " + remainingLimit);
        }
        remainingLimit -= amount;
    }

    public long remainingLimit() {
        return remainingLimit;
    }
}
