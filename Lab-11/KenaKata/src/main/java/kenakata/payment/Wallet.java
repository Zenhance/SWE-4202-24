package kenakata.payment;

public class Wallet{
    private long balance;
}
public Wallet(long initialBalance){
    if(initialBalance < 0){
        throw new IllegalArgumentException("Initial balance cant be negative");
    }
    this.balance= initialBalance;
}
public long balance(){
    return balance;
}
