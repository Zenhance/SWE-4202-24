public class InsufficientBalanceException extends TransactionException {
    public InsufficientBalanceException(String id) { super("Insufficient balance: " + id); }
}