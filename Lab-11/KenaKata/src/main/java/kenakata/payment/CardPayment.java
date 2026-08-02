package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.PaymentDeclinedException;

public class CardPayment implements PaymentMethod{
    private long remainingLimit;

    public CardPayment(Long limit) {
        this.remainingLimit=limit;
    }
    public long remainingLimit() {
        return remainingLimit;
    }

    @Override
    public void authorise(long amount) throws CardLimitExceededException {
        if(amount>remainingLimit) {
            throw new CardLimitExceededException("");
        }
        remainingLimit -= amount;
    }
}
