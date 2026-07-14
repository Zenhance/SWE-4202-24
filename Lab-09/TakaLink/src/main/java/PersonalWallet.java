public class PersonalWallet extends Wallet{
    private static final double personallimit=25000;

    protected PersonalWallet(String id, double balance, String pin) {
        super(id, balance, pin);
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
