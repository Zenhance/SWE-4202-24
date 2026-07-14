public class PersonalWallet extends Wallet {
    public PersonalWallet(String id, double amount, String pin) {
        super(id, amount, pin);
    }

    @Override
    public boolean allowedOperations(Operation operation) {
        return true;
    }

    @Override
    public double dailyLimit() {
        return 25000;
    }
}
