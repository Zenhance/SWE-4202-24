public class PersonalWallet extends Wallet {

    private static final double DAILY_LIMIT = 25_000.0;

    public PersonalWallet(String id,
                          double openingBalance,
                          String pin) {

        super(id, openingBalance, pin);
    }

    @Override
    public double dailyLimit() {
        return DAILY_LIMIT;
    }

    @Override
    public boolean allows(TransactionType type) {
        return true;
    }

    }
