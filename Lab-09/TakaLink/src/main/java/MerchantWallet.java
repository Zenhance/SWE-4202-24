public class MerchantWallet extends Wallet {
    public MerchantWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }

    @Override
    public double getDailyLimit() {
        return 0.0;
    }
}
