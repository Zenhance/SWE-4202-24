public class AgentWallet extends Wallet {

    private static final double DAILY_LIMIT = 500_000.0;

    public AgentWallet(String id,
                       double openingBalance,
                       String pin) {

        super(id, openingBalance, pin);
    }

    @Override
    public double dailyLimit() {
        return DAILY_LIMIT;
    }

    @Override
    public boolean allows(TransactionType type) {
        return true;
    }
}
