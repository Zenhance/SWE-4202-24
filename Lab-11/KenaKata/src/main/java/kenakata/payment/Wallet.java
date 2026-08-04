package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;
public class Wallet {
    private long balance;

    public Wallet(long balance){
        if(balance<0){
            throw new IllegalArgumentException("Negative balance");}

        this.balance = balance;
    }

    public long balance(){
        return balance;
    }

    public void debit(long amount)
            throws EmptyWalletException{

        if(amount>balance){
            throw new EmptyWalletException("Insufficient wallet balance");}

        balance -= amount;
    }

    public void credit(long amount){
        if(amount <=0){throw new IllegalArgumentException("Invalid credit");
        }
        balance += amount;
    }

}