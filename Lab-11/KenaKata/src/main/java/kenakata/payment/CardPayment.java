package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;

public class CardPayment extends PaymentMethod{
    int amount;
    public CardPayment(int i) {
        this.amount = i;
    }

    public int remainingLimit() {
        return 0;
    }
    public void authorise(int amount) {
        if(this.amount < amount) {
            this.amount-=amount;
        }

    }
}
