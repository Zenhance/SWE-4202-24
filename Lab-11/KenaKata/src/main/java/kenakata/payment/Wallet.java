package kenakata.payment;
import kenakata.exceptions.EmptyWalletException;

public final class Wallet {
    private long balance;
    public Wallet(long openingBalance){
        if(openingBalance<0){
            throw new IllegalArgumentException("Wallet balance cannot be negative");
        }
        this.balance = openingBalance;
    }
}
