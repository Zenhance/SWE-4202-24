public class AgentWallet extends Wallet{
    private static final double DAILY_LIMIT=50000.0;
public AgentWallet(String id, double balance,String pin){
    super(id,balance,pin);
}
    public double dailyLimit(){
        return DAILY_LIMIT;
    }

    public boolean canSendOut(){
        return true;
    }

    public boolean canCashOut(){
        return true;
    }
}

