package kenakata.payment;
import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.PaymentDeclinedException;

import javax.smartcardio.Card;

public abstract class CardPayment implements PaymentMethod {
    private long limit;// credit or debit limit
    public CardPayment(long limit){

        this.limit=limit;
    }
    public long remainingLimit(){

        return limit;
    }
    @Override
    public void authorise(long amount) throws PaymentDeclinedException{
        if(amount > limit){
            throw new CardLimitExceededException("Card limit exceeded");
        }
        limit-=amount;
    }
}
