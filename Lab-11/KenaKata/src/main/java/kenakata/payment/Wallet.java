package kenakata.payment;

public class Wallet {

    int amount;

    public Wallet(int amount) {
        if(amount <= 0)
            throw new IllegalArgumentException("Invalid amount");
        this.amount = amount;
    }

    public int balance(){return amount;}
}
