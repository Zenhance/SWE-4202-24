public class FrozenAccountException extends TransactionException {
    public FrozenAccountException() {
        super("Account is frozen.");
    }
    public FrozenAccountException(String message) {
        super(message);
    }
}
