public class MerchantWallet extends Wallet{
    private static final double DAILY_LIMIT = 0;
    public MerchantWallet(String id,double balance,String pin) {
        super(id, balance,pin);
    }

    @Override
    public double getDailyLimit() {
        return DAILY_LIMIT;
    }
    @Override
    public boolean canPerform(Transaction transaction) {
        if(transaction instanceof SendTransaction) {
            return false;
        }
        if(transaction instanceof CashOutTransaction) {
            return false;
        }
        return true;
}
}
