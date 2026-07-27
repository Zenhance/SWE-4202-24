public class InsufficientBalanceException extends TransactionException{
    public InsufficientBalanceException() {
        super("Insufficient balance.");
    }
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
