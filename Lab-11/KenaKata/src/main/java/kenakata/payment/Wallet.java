package kenakata.payment;

public class Wallet {
    private long balance;
    public Wallet(long balance){
        if(balance<0){
            throw new IllegalArgumentException();
        }
        this.balance=balance;
    }
    public long balance(){
        return balance;
    }
    void deduct(long amount){
        balance-=amount;
    }
}
