public class DailyLimitExceededException
        extends TransactionException {

    public DailyLimitExceededException() {
        super("Daily limit exceeded");
    }
}
