package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

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

    public void debit(int amount) throws EmptyWalletException {
        if (amount > balance)
            throw new EmptyWalletException("Not enough balance");

        balance -= amount;
    }
}
