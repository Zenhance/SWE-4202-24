public class MerchantWallet extends Wallet{
    public MerchantWallet(String id,double openingBalance, String pin) {
        super(id, openingBalance, pin);
    }
    @Override
    public double dailyLimit() {
        return 0.0;

    }
    @Override
    public boolean canPerform(String operation){
        return !operation.equals("SEND") && !operation.equals("CASHOUT");

    }
}
