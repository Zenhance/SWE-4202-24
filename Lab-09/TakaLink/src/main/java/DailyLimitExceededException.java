public class DailyLimitExceededException extends TransactionException{
    protected DailyLimitExceededException(String message) {
        super(message);
    }
}
