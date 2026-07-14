public final class MerchantWallet extends Wallet{
    private static final double DAILY_LIMIT = 0.0;

    public MerchantWallet(String id, double openingBalance, String pin){
        super(id, openingBalance, pin);
    }
    @Override
    public double dailyLimit(){
        return DAILY_LIMIT;
    }
    @Override
    protected boolean allows(Operation operation){
        return operation!=Operation.SEND_MONEY && operation!=Operation.CASH_OUT;
    }
}
