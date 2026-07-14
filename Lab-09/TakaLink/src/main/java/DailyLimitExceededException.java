public class DailyLimitExceededException extends TransactionException{

    public DailyLimitExceededException(String message) {
        super("Daily limit reached");
    }
}
