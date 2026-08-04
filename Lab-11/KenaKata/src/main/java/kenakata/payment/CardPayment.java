package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;


public class CardPayment implements PaymentMethod {
    public long limit, amount;

    public CardPayment(long limit) {
        if (limit < 0)
            throw new IllegalArgumentException();
        this.limit = limit;
    }

    @Override
    public void authorise(long amount) throws CardLimitExceededException {

        if (amount>limit)
            throw new CardLimitExceededException("limit exceeded");
        this.amount=amount;
    }


    @Override
    public long remainingLimit() {
        return limit-amount;
    }
}
