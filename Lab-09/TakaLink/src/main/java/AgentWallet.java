public class AgentWallet extends Wallet{
    private static final double DAILY_LIMIT = 500000.0;
    public AgentWallet(String name, double balance, String pin) {
        super(name, balance, pin);
    }
}
