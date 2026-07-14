public class AgentWallet extends Wallet{
    private static final double DAILY_LIMIT=200000;
    public AgentWallet(String id, double balance,String pin){
        super(id,balance,pin);
    }
}
