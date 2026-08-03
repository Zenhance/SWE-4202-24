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
    public long balance(){
        return balance;
    }
    public void ensureCanDebit(long amount)
        throws EmptyWalletException{
        validatePositiveOrZero(amount);
        if(amount>balance){
            throw new EmptyWalletException("Wallet balance is insufficient");
        }
    }
public void debit(long amount)throws EmptyWalletException{
        ensureCanDebit(amount);
        balance-=amount;
}
public void credit(long amount){
        if(amount<=0){
            throw new IllegalArgumentException("Credit amount must be positive");
        }
        balance = Math.addExact(balance,amount);
}
private static void validatePositiveOrZero(long amount){
        if(amount<0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
}
}
