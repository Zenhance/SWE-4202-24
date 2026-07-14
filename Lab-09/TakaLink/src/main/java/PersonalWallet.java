public class PersonalWallet extends Wallet{
    public PersonalWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }



    @Override
    public double dailyLimit() {
        return 0;
    }

    @Override
    public boolean canSend() {
        return false;
    }

    @Override
    public boolean canCashOut() {
        return false;
    }
}
