public class AgentWallet extends Wallet{
    private String type;
    private String pin;
    private String balance;
    private final double dailySendingLimit = 500000;

    public AgentWallet(String type, String pin, String balance) {
        super(type, pin, balance);
    }

    @Override
    public boolean cashOut() {
        return false;
    }

    @Override
    public boolean sendMoney() {
        return true;
    }

    @Override
    public boolean receiveMoney() {
        return true;
    }
}
