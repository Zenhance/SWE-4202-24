public class DailyLimitExceededException extends TransactionException {
    private final String walletId;
    private final double amount;
    private final double remainingLimit;

    public DailyLimitExceededException(String walletId, double amount, double remainingLimit) {
        super("");
        this.walletId = walletId;
        this.amount = amount;
        this.remainingLimit = remainingLimit;
    }

    public String getWalletId() { return walletId; }
    public double getAmount() { return amount; }
    public double getRemainingLimit() { return remainingLimit; }
}
