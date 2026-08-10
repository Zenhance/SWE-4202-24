package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class Wallet {
    private long balance;

    public Wallet(long balance) {
        if(balance<0){
            throw new IllegalArgumentException("balance cannot be negative");
        }
        this.balance = balance;
    }

    public long balance() {
        return balance;
    }
    public void debit(long amount) throws EmptyWalletException{
        if(balance<amount){
            throw new EmptyWalletException("You dont have sufficient balance");
        }
        balance -= amount;
    }

}
