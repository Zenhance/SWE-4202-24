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


    public long remainingLimit() {
        return remainingLimit;
    }
}
