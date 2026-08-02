package kenakata.payment;

public final class Wallet {

    private long balance;

    public Wallet(long initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must not be negative");
        }
        this.balance = initialBalance;
    }
    public long balance() {
        return balance;
    }

    void debit(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("");
        }
        if (amount > balance) {
            throw new IllegalStateException("");
        }
        balance -= amount;
    }

    public void credit(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("");
        }
        balance += amount;
    }
}