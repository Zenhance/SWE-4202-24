package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class Wallet{

    private double balance;

    public Wallet(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void wallet(double amount) throws EmptyWalletException{
        if(amount > balance){
            throw new EmptyWalletException("Amount cannot be greater than balance");
        }
        balance -= amount;
    }
}
