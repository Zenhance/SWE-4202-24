public class AgentWallet extends Wallet{
    private final double limit = 500000.0;

    public AgentWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }
}
