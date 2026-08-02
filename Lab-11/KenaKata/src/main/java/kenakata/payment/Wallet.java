package kenakata.payment;

public class Wallet {
    private double balance;

    public Wallet(double balance){
        if(balance<0)
            throw new IllegalArgumentException("Invalid Amount");


        this.balance =balance;
    }

    public double balance() {
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

    public void debit(long amount){
        if(amount>balance) {
            throw new IllegalArgumentException("Invalid Debit Amount");
        }
        balance-=amount;
    }


}




