package kenakata.payment;

public class Wallet {
    private int balance;

    public Wallet(int balance) {
        if (balance <= 0)
            throw new IllegalArgumentException("Balance cannot be negative or zero");
        this.balance = balance;
    }

    public int balance() {
        return balance;
    }
}
