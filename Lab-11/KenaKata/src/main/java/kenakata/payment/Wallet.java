package kenakata.payment;

public class Wallet {
    double wallet;

    public Wallet(double wallet){
        if(wallet<0)
            throw new IllegalArgumentException("Invalid Amount");


        this.wallet=wallet;
    }

    public double getWallet() {
        return wallet;
    }
}




