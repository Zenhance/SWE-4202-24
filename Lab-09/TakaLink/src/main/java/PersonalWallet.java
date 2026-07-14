public class PersonalWallet extends Wallet {
    private static final double DAILY_LIMIT = 25_000.0;
    public PersonalWallet(String name, double balance, String pin) {
        super(name, balance, pin);
    }
}