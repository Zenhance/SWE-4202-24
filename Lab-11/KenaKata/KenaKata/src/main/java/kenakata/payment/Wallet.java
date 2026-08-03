package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public final class Wallet {
    private long balance;

    public Wallet(long openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.balance = openingBalance;
    }

    public long balance() {
        return balance;
    }

    public void debit(long amount) throws EmptyWalletException {
        if (amount < 0) {
            throw new IllegalArgumentException("Debit cannot be negative");
        }
        if (amount > balance) {
            throw new EmptyWalletException("Wallet balance is too low");
        }
        balance -= amount;
    }

    public void credit(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Credit must be positive");
        }
        balance = Math.addExact(balance, amount);
    }
}
