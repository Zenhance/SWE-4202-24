public class PersonalWallet extends Wallet {
    private static final double LIMIT = 25_000.0;
    public PersonalWallet(String id, double balance, String pin)
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
