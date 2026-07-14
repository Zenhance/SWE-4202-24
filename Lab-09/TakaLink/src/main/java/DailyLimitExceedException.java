public class DailyLimitExceedException extends TransactionRefused{
    private final double spentToday;
    private final double dailyLimit;
    private final double attemptedAmount;

    public DailyLimitExceedException(String message, double spentToday, double dailyLimit, double attemptedAmount) {
        super(message);
        this.spentToday = spentToday;
        this.dailyLimit = dailyLimit;
        this.attemptedAmount = attemptedAmount;
    }
    public double getSpentToday() {
        return spentToday;
    }
    public double getDailyLimit() {
        return dailyLimit;
    }
    public double getAttemptedAmount() {
        return attemptedAmount;
    }

}
