package kenakata.payment;

public class Wallet {
    private int balance;
    public Wallet(int balance) {
        if(balance < 0){
            throw new IllegalArgumentException("balance must be greater than 0");
        }
        this.balance = balance;
    }
    public int balance() {
        return 0;
    }
}
