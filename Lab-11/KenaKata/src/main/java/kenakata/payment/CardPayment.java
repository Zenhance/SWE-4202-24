package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public class CardPayment implements PaymentMethod {
    private long limit;

    public CardPayment(long limit) {
        this.limit = limit;
    }


    @Override
    public void authorise(long amount) throws CardLimitExceededException {

    }

    public long limit() {
        return limit;
    }
}
