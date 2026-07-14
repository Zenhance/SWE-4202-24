public class PersonalWallet extends Wallet{
    //Change this value if your test file specifies a different limit
    private static final double DAILY_LIMIT=25000.0;
    public PersonalWallet(String id,double openingBalance,String pin){
        super(id,openingBalance,pin);
    }
    @Override
    public double getDailyLimit(){
        return DAILY_LIMIT;
    }
    @Override public void checkOperationAllowed(Transaction transaction)
        throws OperationNotAllowedException{
        //Personal wallets can perform every transaction.
        //Therefore,nothing needs to be checked.
    }
}
