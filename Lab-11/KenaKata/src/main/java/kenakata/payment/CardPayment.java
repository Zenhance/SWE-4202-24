package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.PaymentDeclinedException;

public class CardPayment implements PaymentMethod{
    private int limit;
    public CardPayment(int limit){
        this.limit=limit;
    }

    public int getRemaininglimit() {
        return this.limit;
    }

    @Override
    public void authorise(long amount) throws CardLimitExceededException {
  if(amount>limit)
      throw new CardLimitExceededException("Limit has passsed");
      limit-=amount;
    }
}
