package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.PaymentDeclinedException;


public class CardPayment implements PaymentMethod {
    private long remainingLimit;
    public CardPayment(long limit) {
        if (limit < 0) {
            throw new IllegalArgumentException();
        }

        this.remainingLimit = limit;
    }

    @Override
    public void authorise(long amount)
            throws PaymentDeclinedException {

        if (amount <= 0) {
            throw new IllegalArgumentException();
        }

        if (amount > remainingLimit) {
            throw new CardLimitExceededException();
        }

        remainingLimit -= amount;
    }

    public long remainingLimit() {
        return remainingLimit;
    }
}
