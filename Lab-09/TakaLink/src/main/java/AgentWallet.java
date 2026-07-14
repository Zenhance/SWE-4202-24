public class AgentWallet extends Wallet {
    private static final double LIMIT = 500_000.0;

    public AgentWallet(String id, double balance, String pin)
    {
        super(id, balance, pin);
    }

    @Override
    protected double dailyLimit()
    {
        return LIMIT;
    }
    @Override
    public boolean maySend()
    {
        return true;
    }
    @Override
    public boolean mayCashOut()
    {
        return true;
    }
}
