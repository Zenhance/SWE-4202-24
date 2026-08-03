public class DailyLimitExceededException extends TransactionException{
        DailyLimitExceededException(String message){
            super(message);
        }
}
