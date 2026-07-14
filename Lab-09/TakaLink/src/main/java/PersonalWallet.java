public class PersonalWallet extends Wallet{
    private static final double personallimit=25000;
    protected PersonalWallet(String id, double balance, String pin, boolean frozen, double spentToday) {
        super(id, balance, pin, frozen, spentToday);
    }

    @Override
    protected double getDailylimit() {
        return personallimit;
    }

    @Override
    protected boolean canPay() {
        return true;
    }
}
