package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.CodCeilingExceededException;

public class Wallet {
    int amount=0;
    public Wallet(int amount) {
        if(amount<0) throw new IllegalArgumentException();
        this.amount = amount;
    }

    public String balance() {
        return "0";
    }
    public void authorise(int amount) {
        if(amount<=this.amount) this.amount-=amount;
    }
}
