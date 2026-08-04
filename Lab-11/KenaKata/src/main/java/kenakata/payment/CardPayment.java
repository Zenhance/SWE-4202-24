package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public class CardPayment extends PaymentMethod{
    int amount;
    public CardPayment(int i) {
        this.amount = i;
    }

    public int remainingLimit() {
        return amount;
    }
    public void authorise(int amount) throws CardLimitExceededException {
        if(this.amount < amount) {
            this.amount-=amount;
        }
        else throw new CardLimitExceededException();
    }
}
