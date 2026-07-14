public class MerchantWallet extends Wallet {
    private static final double LIMIT = 0.0;
    public MerchantWallet(String id, double balance, String pin)
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
        return false;
    }

    @Override
    public boolean mayCashOut()
    {
        return false;
    }
}
