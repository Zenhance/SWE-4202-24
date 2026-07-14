public class AgentWallet extends Wallet{
     public static final double DAILY_LIMIT=50000.0;
    public AgentWallet(String id, double balance, String pin) {
        super(id, balance, pin);
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
}
