package kenakata.payment;

public class Wallet {
    private int balance;

    public Wallet(int balance){
        if(balance<0){
            throw new IllegalArgumentException();
        }
        this.balance=balance;
    }

    public int balance(){
        return balance;
    }

    public void deduct(int amount){
        balance-=amount;
    }
}
