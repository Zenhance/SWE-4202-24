public class AgentWallet extends Wallet{
    private static final double limit=500000;

    protected AgentWallet(String id, double balance, String pin, boolean frozen, double spentToday) {
        super(id, balance, pin, frozen, spentToday);
    }

    @Override
    protected double getDailylimit() {
        return limit;
    }

    @Override
    protected boolean canPay(TransactionType type) {
        return true ;
    }
}
