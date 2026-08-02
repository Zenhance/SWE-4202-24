package kenakata.payment;

public class Wallet {
    private long balance;
    public Wallet(long balance) {
        if(balance < 0) {
            throw new IllegalArgumentException("Invalid balance");
        }
        this.balance = balance;
    }
    public long balance() {
        return balance;
    }
    public void reduce(long amount) {
        balance -= amount;
    }
}