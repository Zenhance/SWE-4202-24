package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.CodCeilingExceededException;

public class Wallet {
    int amount=0;
    public Wallet(int amount) {
        if(amount<0) throw new IllegalArgumentException();
        this.amount = amount;
    }

    public int balance() {
        return amount;
    }

}
