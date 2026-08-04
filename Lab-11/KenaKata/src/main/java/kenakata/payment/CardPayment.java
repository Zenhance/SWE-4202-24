package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public class CardPayment implements PaymentMethod {
    private long remainingLimit;
    public CardPayment(long limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Card limit must not be negative");
        }
        this.remainingLimit = limit;
    }

    public void authorise(int i) throws CardLimitExceededException {
    }

    public int remainingLimit() {
        return 1;
    }
}
