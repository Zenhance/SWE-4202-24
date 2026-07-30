package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public class CardPayment implements PaymentMethod{
    private int remainingLimit;

    public CardPayment(int limit){
        if(limit<0){
            throw new IllegalArgumentException();
        }
        this.remainingLimit=remainingLimit;
    }

    public void authorise(int amount)throws CardLimitExceededException{
        if(amount>remainingLimit){
            throw new CardLimitExceededException();
        }
        remainingLimit-=amount;
    }

    public int reaminingLimit(){
        return remainingLimit;
    }
}
