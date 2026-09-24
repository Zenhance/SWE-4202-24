package kenakata.payment;

public class Wallet {
    private int balance;

    public Wallet(int balance){
        if(balance<0){
            throw new IllegalArgumentException("Initial balance can't be negative");
        }
        this.balance=balance;
    }
    public int getBalance(){
        return balance;
    }
}
