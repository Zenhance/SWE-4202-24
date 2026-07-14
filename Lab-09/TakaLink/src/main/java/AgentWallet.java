public class AgentWallet extends Wallet{
    private final double DAILY_LIMIT = 500000.0;
    public AgentWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }
    @Override
    public double dailyLimit() {
        return DAILY_LIMIT;
    }

    @Override
    protected void assertCanReceiveCashOut() {
    }
}
