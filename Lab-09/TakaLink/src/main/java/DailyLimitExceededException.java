public class DailyLimitExceededException extends TransactionException {
    public DailyLimitExceededException(Wallet fromId, double amount) {
        super("Wallet " + fromId.getId() + " has only " + fromId.remainingDailyLimit()
                + " of daily limit left but the transaction needs " + amount);
    }
}
