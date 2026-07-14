public class DailyLimitExceedException extends TransactionExceptions{

    public DailyLimitExceedException(){
        super("Daily Limit Exceeded");
    }
}
