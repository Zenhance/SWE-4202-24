public class MerchantWallet extends Wallet {
    public MerchantWallet(String name, double balance, String pin) {
        super(name, balance, pin);
    }

    @Override
    public double dailyLimit() {
        return 0;
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
    public boolean isAgent() {
        return false;
    }
}
