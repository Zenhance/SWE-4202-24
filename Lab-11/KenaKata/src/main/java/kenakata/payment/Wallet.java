package kenakata.payment;

public class Wallet {
    private long balance;

    public Wallet(long balance) {
        if (balance < 0) throw new IllegalArgumentException("Wallet balance cannot be negative");
        this.balance = balance;
    }

    public long balance() { return balance; }

    public void debit(long amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
    }

    public void credit(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("Credit amount must be positive");
        balance += amount;
    }
}