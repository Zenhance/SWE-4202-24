public class AgentWallet extends Wallet{
    private static final double DAILY_LIMIT = 500_000.0;

    public AgentWallet(String id,double balance,String pin){
        super(id,balance,pin);
    }


}
