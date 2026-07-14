public class DailyLimitExceededException extends TransactionException {

    public DailyLimitExceededException() {
        super();
    }

    public DailyLimitExceededException(String message) {
        super(message);
    }

}
