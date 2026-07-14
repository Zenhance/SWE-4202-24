public class DailyLimitExceedException extends TransactionException{
    protected DailyLimitExceedException(String message) {
        super(message);
    }
}
