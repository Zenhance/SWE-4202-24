package kenakata.payment;

import kenakata.exceptions.*;

public class Wallet {
    private long balance;

    public Wallet(long balance) {
        if (balance < 0) throw new IllegalArgumentException("Wallet balance cannot be negative");
        this.balance = balance;
    }

    public long balance() { return balance; }

    public void deduct(long amount) throws EmptyWalletException {
        if (amount > balance) throw new EmptyWalletException("Insufficient wallet balance");
        balance -= amount;
    }
}

