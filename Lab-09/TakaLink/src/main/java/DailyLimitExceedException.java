package src.main.java;

public class DailyLimitExceedException  extends TransactionException{
    public DailyLimitExceedException(){
        super("Daily Limit has been Exceeded");
    }
}
