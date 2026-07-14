public class AgentWallet extends Wallet{
    //Change this value if your test file specifies a different limit.
    private static final double DAILY_LIMIT=200000.0;
    public AgentWallet(String id,double openingBalance,String pin){
        super(id,openingBalance,pin);
    }
    @Override
    public double getDailyLimit(){
        return DAILY_LIMIT;
    }
    @Override
    public void checkOperationAllowed(Transaction transaction)
        throws OperationNotAllowedException{
        //Agent wallets are allowed to perform all supported transactions.No
        // Restriction is required here.
    }
}
