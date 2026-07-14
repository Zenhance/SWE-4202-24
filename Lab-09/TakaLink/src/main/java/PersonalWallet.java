public class PersonalWallet extends Wallet{
    public final double limit = 25000.0;
    public PersonalWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }

}