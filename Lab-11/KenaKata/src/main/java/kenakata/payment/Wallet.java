package kenakata.payment;

public class Wallet {
    private double balance;

    public double balance() {
        return balance;
    }
    public void credit(double amount) {
        balance = balance + amount;
    }
    public void debit(double amount) {
        balance = balance - amount;
    }
}
