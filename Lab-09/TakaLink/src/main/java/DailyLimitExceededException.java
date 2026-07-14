package src.main.java;

public class DailyLimitExceededException extends TransactionException{
    public DailyLimitExceededException(String message){
        super(message);
    }
}
