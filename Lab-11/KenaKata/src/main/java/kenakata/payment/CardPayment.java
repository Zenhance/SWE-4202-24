package kenakata.payment;

import kenakata.payment.PaymentMethod;
import kenakata.exceptions.CardLimitExceededException;

public class CardPayment extends PaymentMethod {
    private long limit;

    public CardPayment(long limit) {
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
}
