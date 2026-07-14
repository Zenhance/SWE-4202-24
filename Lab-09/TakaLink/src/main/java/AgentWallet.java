public class AgentWallet extends Wallet{
    public static final double DailyLimit=50000.00;

    public AgentWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }

    @Override
    public double dailyLimit() {
        return DailyLimit;
    }

    @Override
    public boolean canSend() {
        return true;
    }

    @Override
    public boolean canCashOut() {
        return true;
    }
}
