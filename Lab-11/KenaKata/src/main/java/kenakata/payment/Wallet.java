package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class Wallet {
    private long balance;

    public Wallet(long balance) {
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
