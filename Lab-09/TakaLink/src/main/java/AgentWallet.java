package main.java;

public class AgentWallet extends Wallet{
    private static final double LIMIT=500000.0;
    public AgentWallet(String id,double balance,String pin){
        super(id,balance,pin);
    }
    public double getDailyLimit(){
        return LIMIT;
    }
    public boolean canSend(){
        return true;
    }
    public boolean canCashOut(){
        return true;
    }
}
