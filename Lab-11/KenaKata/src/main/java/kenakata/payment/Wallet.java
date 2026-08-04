package kenakata.payment;

public class Wallet {
    private long balance;

    public Wallet(long initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    public long balance() {
        return balance;
    }

    public void withdraw(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount must be non-negative.");
        }
        this.balance -= amount;
    }
}