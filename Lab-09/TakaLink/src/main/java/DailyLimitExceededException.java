public class DailyLimitExceededException extends TransactionException{
    public DailyLimitExceededException(){
        super("Limit exceeded");
    }
}
