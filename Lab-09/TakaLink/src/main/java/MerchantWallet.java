public class MerchantWallet extends Wallet{

    public MerchantWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }

    @Override
    public double dailyLimit() {
        return 0.0;
    }

    @Override
    public boolean canSend() {
        return false;
    }

    @Override
    public boolean canCashOut() {
        return false;
    }

    @Override
    public double fee() {
        return 0;
    }
}
