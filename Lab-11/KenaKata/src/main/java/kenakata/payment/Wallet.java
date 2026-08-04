package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.CodCeilingExceededException;

public class Wallet {
    int amount=0;
    public Wallet(int amount) {
        this.amount = amount;
    }

    public String balance() {
        return String.format(String.valueOf(this.amount));
    }
    public void authorise(int amount) {
        if(amount<=this.amount) this.amount-=amount;
    }
}
