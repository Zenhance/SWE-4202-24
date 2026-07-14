public class AgentWallet extends Wallet{
    private static final double limit=500000;

    protected AgentWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }


    @Override
    protected double getDailylimit() {
        return limit;
    }

    @Override
    protected boolean canPay() {
        return true ;
    }
}
