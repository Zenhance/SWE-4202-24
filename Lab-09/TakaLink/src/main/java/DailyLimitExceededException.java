public class DailyLimitExceededException extends Exception {
    public DailyLimitExceededException(double canSend) {
        super("Transaction exceeds Daily Limit, Can send: " + canSend);
    }
}
