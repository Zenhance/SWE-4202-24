public class DailyLimitExceededException extends TransactionException {
    public DailyLimitExceededException(String id) { super("Daily limit exceeded: " + id); }
}