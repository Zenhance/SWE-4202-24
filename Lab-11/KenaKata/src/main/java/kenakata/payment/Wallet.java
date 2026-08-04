package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class Wallet {
    private long balance;

    public Wallet(long balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = balance;
    }

    public long balance() { return balance; }

    public void debit(long amount) throws EmptyWalletException {
        if (amount < 0) {
            throw new IllegalArgumentException("Debit amount must be positive");
        }
        if (balance < amount) {
            throw new EmptyWalletException("Wallet balance insufficient");
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
