package kenakata.payment;

import kenakata.payment.PaymentMethod;
import kenakata.exceptions.CardLimitExceededException;

public class CardPayment extends PaymentMethod {
    private long limit;

    public CardPayment(long limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Card limit cannot be negative");
        }
        this.limit = limit;
    }

    public long getLimit() {
        return limit;
    }

    @Override
    public  void authorise(long value) throws CardLimitExceededException {
        if(limit<value){
            throw new CardLimitExceededException("Card limit exceed");
        }
        limit -= value;
    }

    public long remainingLimit() {
        return limit;
    }
}
