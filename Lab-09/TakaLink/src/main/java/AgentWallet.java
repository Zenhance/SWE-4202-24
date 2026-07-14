public class AgentWallet extends Wallet{
    public AgentWallet(String id,double initialBalance,String pin){
        super(id,initialBalance,pin);
    }

    @Override
    public double getDailyLimit() {
        return 500000;
    }

}
