public class InsufficientBalanceException extends TransactionException {
    protected InsufficientBalanceException(String message) {
        super(message);
    }
}
