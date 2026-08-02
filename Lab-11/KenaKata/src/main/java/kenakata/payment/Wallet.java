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

    public void credit(long amount){
        if(amount <=0){ throw new IllegalArgumentException("Invalid Credit Amount");
        }
        balance+=amount;
    }


}




