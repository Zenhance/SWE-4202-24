public class PersonalWallet extends Wallet{
    public PersonalWallet(String a, double v, String number) {
        super(a,v,number);

    }

    @Override
    public double getDailyLimit() {
        return 25000;
    }

}
