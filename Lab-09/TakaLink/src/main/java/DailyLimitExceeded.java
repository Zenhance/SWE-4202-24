public class DailyLimitExceeded extends TransactionException{

    public DailyLimitExceeded(String message) {
        super("Daily limit reached");
    }
}
