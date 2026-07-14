public class MerchantWallet extends Wallet {

    public MerchantWallet(
            String id,
            double openingBalance,
            String pin
    ) {
        super(id, openingBalance, pin);
    }

    @Override
    protected double dailyLimit() {
        return 0;
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
        return false;
    }

    @Override
    public boolean canTopUp() {
        return false;
    }
}