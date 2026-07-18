public class PersonalWallet extends Wallet{
    private double remainingLimit;

    public PersonalWallet(String name, double balance, String PIN) {
        super(name, balance, PIN);
        remainingLimit = 25_000; // Daily limit for personal wallet
    }

    @Override
    public void debit(double amount) throws TransactionException {
        if (amount > remainingLimit)
            throw new DailyLimitExceededException("Daily limit exceeded");
        super.debit(amount);
        remainingLimit -= amount;
    }
}
