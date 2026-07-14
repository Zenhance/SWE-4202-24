public final class MerchantWallet extends Wallet {

    private static final double DAILY_LIMIT = 0.0;

    public MerchantWallet(String id, double openingBalance, String pin) {
        super(id, openingBalance, pin);
    }

    @Override
    protected double dailyLimit() {
        return DAILY_LIMIT;
    }

    @Override
    public boolean canSendMoney() {
        return false;
    }

    @Override
    public boolean canCashOut() {
        return false;
    }

    @Override
    public boolean canMakePayment() {
        return true;
    }

    @Override
    public boolean canTopUp() {
        return true;
    }

    @Override
    public boolean canReceivePayment() {
        return true;
    }
}