package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

/**
 * A customer's mobile wallet. It reports its balance and can be debited or credited, but its
 * balance cannot be set directly from outside -- only through those two operations.
 */
public final class Wallet {

    private long balance;

    public Wallet(long initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("initialBalance must not be negative");
        }
        this.balance = initialBalance;
    }

    public long balance() {
        return balance;
    }

    /** Debits {@code amount}, refusing if the balance would go below zero. */
    public void debit(long amount) throws EmptyWalletException {
        if (amount > balance) {
            throw new EmptyWalletException("wallet balance " + balance + " is too low for " + amount);
        }
        balance -= amount;
    }

    /** Credits {@code amount}; only positive amounts are accepted. */
    public void credit(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        balance += amount;
    }
}
