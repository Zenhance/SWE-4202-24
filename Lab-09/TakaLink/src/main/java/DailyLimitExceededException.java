public class DailyLimitExceededException extends TransactionException {

    public DailyLimitExceededException() {
        super("Daily transaction limit exceeded");
    }

    public DailyLimitExceededException(String message) {
        super(message);
    }
}