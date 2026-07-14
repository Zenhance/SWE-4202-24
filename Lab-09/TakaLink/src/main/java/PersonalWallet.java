public class PersonalWallet extends Wallet {
    private static final double DAILY_LIMIT = 25_000.0;
    public PersonalWallet(String name, double balance, String pin) {
        super(name, balance, pin);
    }
    @Override
    public double dailyLimit() {
        return DAILY_LIMIT;
    }

    @Override
    public boolean canSend() {
        return true;
    }

    @Override
    public boolean canCashOut() {
        return true;
    }

    @Override
    public boolean isAgent() {
        return false;
    }
}