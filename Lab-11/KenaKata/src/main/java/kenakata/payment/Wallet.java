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
    public void recharge(int amount){
        if(amount<=0){
            throw new IllegalArgumentException("Recharge amount cannot be negative nor zero");
        }
        this.balance=balance;
    }
}
