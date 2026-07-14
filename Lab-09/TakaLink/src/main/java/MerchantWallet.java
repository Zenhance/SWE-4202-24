public class MerchantWallet extends Wallet{
    private final double DAILY_LIMIT = 0.0
    public MerchantWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }
    @Override
    public double dailyLimit() {
        return DAILY_LIMIT;
    }
    @Override
    protected void assertCanSend() throws OperationNotAllowedException {
        throw new OperationNotAllowedException(id() + " is a merchant and it does not send money");
    }
}
