package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public final class Wallet {
    private long balance;
    
    public Wallet(long openingBalance) {
        requireNonNegative(openingBalance);
        balance = openingBalance;
    }
    public long balance() {
        return balance;
    }
    
    public void canBeDebited(long amount) throws EmptyWalletException {
        requireNonNegative(amount);
        if (balance < amount) {
            throw new EmptyWalletException("Insufficient balance.");
        }
    }
    
    public void requireNonNegative(long amount){
        if(amount < 0){
            throw new IllegalArgumentException("amount cannot be negative");
        }
    }
    
    public void debit(long amount) throws EmptyWalletException{
        canBeDebited(amount);
        balance-=amount;
    }
    public void credit(long amount){
        if(amount<=0){
            throw new IllegalArgumentException("Credit amount must be positive.");
        }
        balance = balance+amount;
    }
}
