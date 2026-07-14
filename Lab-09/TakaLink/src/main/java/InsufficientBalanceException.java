public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException( String message ) {
        super ( message ) ; // hand the message up to Exception
    }
}