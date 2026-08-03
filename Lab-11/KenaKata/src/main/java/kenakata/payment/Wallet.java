package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class Wallet {

    public long balance;
    public Wallet(long balance) {
        if (balance<=0)
            throw new IllegalArgumentException();
        this.balance=balance;
    }

    public double balance() {
    return balance;
    }
    public void credit(long amount) {
        if (amount<=0)
            throw new IllegalArgumentException();
        balance+=amount;
    }
     void debit(long amount) throws EmptyWalletException {

         if (amount<0)
             throw new IllegalArgumentException();

         if (balance<amount)
             throw new EmptyWalletException("can not be debited ");
         balance-=amount;
     }}
