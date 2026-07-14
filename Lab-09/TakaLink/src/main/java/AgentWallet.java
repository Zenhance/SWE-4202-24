public class AgentWallet extends Wallet{
    private static final double DAILY_LIMIT = 500000.0;

    public AgentWallet(String id, double openingBalance, String pin){
        super(id, openingBalance, pin);
    }
    @Override
    public double dailyLimit(){
        return DAILY_LIMIT;
    }
    @Override
    public boolean canSendMoney(){
        return true;
    }
    @Override
    public boolean canCashOut(){
        return true;
    }
    @Override
    public boolean canMakePayment(){
        return true;
    }
    @Override
    public boolean canTopUp(){
        return true;
    }
}
