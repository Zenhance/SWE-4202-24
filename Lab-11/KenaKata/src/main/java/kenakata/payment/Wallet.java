package kenakata.payment;

public class Wallet {
    private long balance;
    public Wallet(long balance){
         if(balance<0){
             throw new IllegalArgumentException("Balance cannot be negative");
         }
         this.balance=balance;
    }
    public long balance(){
        return balance;
    }

    public void deduct(long ammount){
        balance-=ammount;
    }
}
