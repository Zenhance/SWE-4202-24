public class AgentWallet extends Wallet{
    private final double DAILY_LIMIT = 500_000;
    private double remainingLimit;

    public AgentWallet(String name, double balance, String PIN) {
        super(name, balance, PIN);
        remainingLimit = DAILY_LIMIT;
    }

    @Override
    public void debit(double amount) throws TransactionException {
        if (amount > remainingLimit)
            throw new DailyLimitExceededException("Daily limit exceeded");
        super.debit(amount);
    }
}
