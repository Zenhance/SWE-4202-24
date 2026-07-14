public class AgentWallet extends Wallet
{
    private static final double LIMIT = 500000.0;

    public AgentWallet(String id, double balance, String pin)
    {
        super(id, balance, pin);
    }

    @Override
    public double dailyLimit()
    {
        return LIMIT;
    }

    @Override
    public boolean canSendMoney()
    {
        return true;
    }

    @Override
    public boolean canPayment()
    {
        return true;
    }

    @Override
    public boolean canCashOut()
    {
        return true;
    }

    @Override
    public boolean canTopUp()
    {
        return true;
    }
}
