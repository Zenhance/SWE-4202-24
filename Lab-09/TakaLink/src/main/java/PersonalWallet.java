public class PersonalWallet extends Wallet{
    private static final double DAILY_LIMIT=25000.0;
    public PersonalWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }


    @Override
    public double fee(){
        return 0.0;
    }
    @Override
    public double dailyLimit() {
        return DAILY_LIMIT;
    }

    @Override
    public boolean canSend() {
        return true;
    }

    @Override
    public boolean canCashOut() {
        return true;
    }
}
