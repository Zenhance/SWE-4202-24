package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public final class Wallet {
    private long balance;

    public Wallet(long balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must not be negative");
        }
        this.balance = balance;
    }

    public long balance() {
        return balance;
    }

    public void debit(long amount) throws EmptyWalletException {
        if (amount > balance) {
            throw new EmptyWalletException("Insufficient wallet balance for " + amount);
        }
        balance -= amount;
    }

    public void credit(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Credit amount must be positive");
        }
        balance += amount;
    }
}