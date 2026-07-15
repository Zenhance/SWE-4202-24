public class MerchantWallet extends Wallet
{
    public MerchantWallet(String id, double balance, String pin)
    {
        super(id, balance, pin);
    }

    @Override
    public double dailyLimit()
    {
        return 0.0;
    }

    @Override
    public boolean canSendMoney()
    {
        return false;
    }

    @Override
    public boolean canPayment()
    {
        return true;
    }

    @Override
    public boolean canCashOut()
    {
        return false;
    }

    @Override
    public boolean canTopUp()
    {
        return true;
    }
}
