public class PersonalWallet extends Wallet {
    public PersonalWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }
    @Override
    public double getDailyLimit() {
        return 25000.0;
    }
}
