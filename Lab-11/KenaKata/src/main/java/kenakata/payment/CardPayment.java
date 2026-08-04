package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.PaymentDeclinedException;

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
    public void authorise(long amount) throws PaymentDeclinedException {

    }
}
