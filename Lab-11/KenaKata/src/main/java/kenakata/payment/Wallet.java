package kenakata.payment;

public class Wallet {

    public long balance;
    public Wallet(long balance) {
        if (balance<=0)
            throw new IllegalArgumentException("must be positive ");
        this.balance=balance;
    }

    public double balance() {
    return 0;
    }
}
