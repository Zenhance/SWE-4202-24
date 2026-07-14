public class MerchantWallet extends Wallet{

    private static final double DAILY_LIMIT=0.0;
    public MerchantWallet(String id, double balance, String pin){
        super(id,balance,pin);
    }
    @Override
    protected double dailyLimit(){
        return DAILY_LIMIT;
    }
}
