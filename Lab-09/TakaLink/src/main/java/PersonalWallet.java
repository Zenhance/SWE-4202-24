public final class PersonalWallet extends Wallet {

    private static final double DAILY_LIMIT = 25_000.0;
    public PersonalWallet(String id, double openingBalance, String pin) {
        super(id, openingBalance, pin);
    }
    @Override
    protected double dailyLimit() {
        return DAILY_LIMIT;
    }
    @Override
    public boolean canSendMoney() {
        return true;
    }
    @Override
    public boolean canCashOut() {
        return true;
    }
    @Override
    public boolean canMakePayment() {
        return true;
    }
    @Override
    public boolean canTopUp() {
        return true;
    }
}