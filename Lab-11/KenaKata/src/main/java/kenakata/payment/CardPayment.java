package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public class CardPayment implements PaymentMethod {
    private long remainingLimit;

    public CardPayment(long limit) {
        this.remainingLimit = limit;
    }

    public long remainingLimit() { return remainingLimit; }

    @Override
    public void authorise(long amount) throws CardLimitExceededException {
        if (amount > remainingLimit) {
            throw new CardLimitExceededException("Card limit exceeded");
        }
        remainingLimit -= amount;
    }
}