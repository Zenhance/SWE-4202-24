public class MerchantWallet extends Wallet{
    //Change this value if your test file specifies other limit.
    private static final double DAILY_LIMIT=0.0;
    public MerchantWallet(String id,double openingBalance,String pin){
        super(id,openingBalance,pin);
    }
    @Override
    public double getDailyLimit(){
        return DAILY_LIMIT;
    }
    @Override
    public void checkOperationAllowed(Transaction transaction)
        throws OperationNotAllowedException{
        if(transaction instanceof SendTransaction){
            throw new OperationNotAllowedException("Merchant wallets cannot send money.");
        }
        if(transaction instanceof CashOuttransaction){
            throw new OperationNotAllowedException("Merchant wallets cannot cash out.");
        }
        //PaymentTransaction and TopUpTransaction are allowed.
    }
}
