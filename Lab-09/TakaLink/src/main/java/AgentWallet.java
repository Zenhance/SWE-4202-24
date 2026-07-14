public class AgentWallet extends Wallet{
    private static final double DAILY_LIMIT = 500000.0;

    public AgentWallet(
            String id, double openingBalance, String pin) {
        super(id, openingBalance, pin);
    }
}