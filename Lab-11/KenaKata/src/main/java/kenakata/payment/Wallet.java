package kenakata.payment;

public class Wallet {
    int amount=0;
    public Wallet(int amount) {
        this.amount = amount;
    }

    public String balance() {
        return String.format("%.2f", this.amount);
    }
}
