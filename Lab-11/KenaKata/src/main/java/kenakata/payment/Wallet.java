package kenakata.payment;

public class Wallet {
    private long balance;

    public Wallet(long balance){
        if(balance<0)
            throw new IllegalArgumentException("Invalid Amount");


        this.balance =balance;
    }

    public long balance() {
        return balance;
    }

    public void debit(double amount){
        if(amount>balance) {
            throw new IllegalArgumentException("Invalid Debit Amount");
        }
        balance-=amount;
    }

    public void credit(double amount){
        if(amount<=0) {
            throw new IllegalArgumentException("Invalid Credit Amount");
        }
        balance+=amount;
    }


}




