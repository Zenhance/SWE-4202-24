package exceptions;

public class DailyLimitExceedException extends TransactionException{
    public DailyLimitExceedException (String message){
        super (message);
    }
}
