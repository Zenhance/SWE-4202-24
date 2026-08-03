package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.PaymentDeclinedException;

public class CardPayment implements PaymentMethod
{
    private long limit;

    public CardPayment(long limit)
    {
        this.limit = limit;
    }

    @Override
    public void authorise(long amount) throws CardLimitExceededException
    {
        if(amount<0)
            throw new IllegalArgumentException("Amount can not be negative");
        if(limit<amount)
            throw new CardLimitExceededException("Limit is low");
        limit=limit-amount;
    }

    public long remainingLimit()
    {
        return limit;
    }
}