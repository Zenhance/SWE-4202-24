package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public class CardPayment implements PaymentMethod {
    private int limit;
    public CardPayment(int limit) {
        this.limit=limit;
    }

    public int remainingLimit() {
        return limit;
    }

    public void authorise(int amount) throws CardLimitExceededException {
        if(amount<0) throw new IllegalArgumentException("amount cannot be negative");
        if(amount>limit) throw new CardLimitExceededException("Limit is too low");
        limit-=amount;
    }
}
