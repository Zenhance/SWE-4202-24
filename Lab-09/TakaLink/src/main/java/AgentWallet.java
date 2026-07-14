public class AgentWallet extends Wallet{

    public AgentWallet(String id,double openingBalance, String pin){
        super(id , openingBalance, pin)
    }
    @Override
    public double dailyLimit() {
        return 500_000.0;
    }

    @Override
    public boolean canPerform(String operation){
        return true;
    }

}
