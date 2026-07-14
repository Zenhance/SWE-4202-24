public class AgentWallet extends Wallet {

    private static final double DAILY_LIMIT = 500_000.0;

    public AgentWallet(String id, double openingBalance, String pin) {
        super(id, openingBalance, pin);
    }

    @Override
    private double dailyLimit() {
        return DAILY_LIMIT;
    }

    @Override
    boolean canBePayerOf(TransactionKind kind) {
        return kind == TransactionKind.SEND;
    }

    @Override
    boolean canBeRecipientOf(TransactionKind kind) {
        return kind == TransactionKind.CASHOUT || kind == TransactionKind.TOPUP;
    }
}