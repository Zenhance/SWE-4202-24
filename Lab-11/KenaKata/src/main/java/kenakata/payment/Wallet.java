package kenakata.payment;

public final class Wallet {

    private long balance;

    public Wallet(long initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must not be negative");
        }
        this.balance = initialBalance;
    }