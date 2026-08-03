package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public final class CardPayment implements PaymentMethod {

    private long remainingLimit;

    public CardPayment(long remainingLimit) {
        if (remainingLimit < 0) {
            throw new IllegalArgumentException(
                    "Card limit cannot be negative"
            );
        }

        this.remainingLimit = remainingLimit;
    }

    public long remainingLimit() {
        return remainingLimit;
    }

    @Override
    public void authorise(long amount)
            throws CardLimitExceededException {

        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Payment amount cannot be negative"
            );
        }

        if (amount > remainingLimit) {
            throw new CardLimitExceededException(
                    "Card limit Tk " + remainingLimit
                            + " is below required Tk " + amount
            );
        }

        remainingLimit -= amount;
    }
}