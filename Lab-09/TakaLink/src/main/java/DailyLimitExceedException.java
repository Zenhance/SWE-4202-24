public class DailyLimitExceedException extends TransactionException{
    public DailyLimitExceedException() {
        super("Daily limit exceeded");
    }
}
