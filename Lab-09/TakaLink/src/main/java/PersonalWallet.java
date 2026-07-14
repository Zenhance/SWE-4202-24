public class PersonalWallet extends Wallet {

    private static final double DAILY_LIMIT = 25_000.0;

    public PersonalWallet(String id, double openingBalance, String pin) {
        super(id, openingBalance, pin);
    }

    @Override
    protected double dailyLimit() {
        return DAILY_LIMIT;
    }

    @Override
    boolean canBePayerOf(TransactionKind kind) {
        return true;
    }

    @Override
    boolean canBeRecipientOf(TransactionKind kind) {
        return kind == TransactionKind.SEND;
    }
}