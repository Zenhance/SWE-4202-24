public class DailyLimitExceededException extends TransactionException{
    public DailyLimitExceededException(){
        super("Daily Limit Exceeded");
    }
}
