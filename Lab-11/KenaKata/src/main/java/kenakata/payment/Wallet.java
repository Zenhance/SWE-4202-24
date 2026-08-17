package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class Wallet {

    private long balance;

    public Wallet(long balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("balance must be >= 0");
        }
        this.balance = balance;
    }

    public long balance() {
        return balance;
    }

    public void debit(long amount) throws EmptyWalletException {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        if (amount > balance) {
            throw new EmptyWalletException("Wallet balance " + balance + " is insufficient for " + amount);
        }
        balance -= amount;
    }

    public void credit(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        balance += amount;
    }
}