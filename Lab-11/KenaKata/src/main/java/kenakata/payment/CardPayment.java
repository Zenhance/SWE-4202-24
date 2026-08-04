package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public class CardPayment implements PaymentMethod{
    private int limit;

    public CardPayment(int limit) {
        if (limit <= 0)
            throw new IllegalArgumentException("Card limit cannot be negative or zero");
        this.limit = limit;
    }

    @Override
    public void authorise(int amount) throws CardLimitExceededException {
        if (amount > limit)
            throw new CardLimitExceededException("Card limit exceeded");

        this.limit -= amount;
    }

    public int remainingLimit() {
        return this.limit;
    }
}
