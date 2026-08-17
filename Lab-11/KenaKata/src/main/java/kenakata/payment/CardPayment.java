package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.EmptyWalletException;

public class CardPayment extends PaymentMethod{
    int amount;

    public CardPayment(int amount) {
        this.amount = amount;
    }

    public int remainingLimit() {
        return amount;
    }
    public void authorise(int amount) throws CardLimitExceededException{
        if(this.amount >= amount) {
            this.amount-=amount;
        }
        else throw new CardLimitExceededException();

    }
}
