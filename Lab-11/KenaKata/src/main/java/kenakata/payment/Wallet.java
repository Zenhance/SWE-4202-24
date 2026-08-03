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

    public long balance() {
        return balance;
    }
}