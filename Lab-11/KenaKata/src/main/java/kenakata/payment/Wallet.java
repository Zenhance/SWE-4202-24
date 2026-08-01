package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class Wallet{

    private int balance;

    public Wallet(int balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public boolean debit(double amount) {
        if(amount <= 0){
            return false;
        }
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean credit(double amount) {
        if(amount <= 0){
            return false;
        }
        balance += amount;
        return true;
    }
}
