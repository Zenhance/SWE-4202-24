package main.java;

public class PersonalWallet extends Wallet{
    private static final double LIMIT=25000.00;
    public PersonalWallet(String id,double balance,String pin){
        super(id,balance,pin);
    }
    public double  getDailyLimit(){
        return LIMIT;
    }
}
