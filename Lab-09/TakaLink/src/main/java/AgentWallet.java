public class AgentWallet extends Wallet {
    public AgentWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }

    @Override
    public double dailyLimit() {
        return 500000.0;
    }
}