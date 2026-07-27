public class DailyLimitExceededException extends TransactionException {
    public DailyLimitExceededException() {
        super("Daily limit exceeded.");
    }
    public DailyLimitExceededException(String message) {
        super(message);
    }
}
