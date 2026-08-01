package kenakata.payment;

public class Wallet{
    private long balance;

public Wallet(long initialBalance){
    if(initialBalance < 0){
        throw new IllegalArgumentException("Initial balance cant be negative");
    }
    this.balance= initialBalance;
}
public long balance(){
    return balance;
}
public void credit(long amount){
    if(amount <=0){
        throw new IllegalArgumentException("Credit amount must be positive");
    }
    balance+=amount;
}
public void debit(long amount){
if(amount>balance){
throw new IllegalArgumentException("Insufficient balance");
}
balance-=amount;
}
}