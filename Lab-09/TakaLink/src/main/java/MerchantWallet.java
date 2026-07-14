package main.java;

public class MerchantWallet extends Wallet{
    public MerchantWallet(String id,double balance,String pin){
        super(id,balance,pin);
    }
    public double getDailyLimit(){
        return 0.0;
    }
    public boolean canSend(){
        return false;
    }
    public boolean canCashOut(){
        return false;
    }
}
