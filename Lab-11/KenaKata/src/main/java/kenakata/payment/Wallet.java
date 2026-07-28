package kenakata.payment;

public class Wallet {

    int amount;

    public Wallet(int amount) {
        this.amount = amount;
    }

    public int balance(){return amount;}
}
