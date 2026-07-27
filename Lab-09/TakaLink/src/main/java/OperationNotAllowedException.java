public class OperationNotAllowedException extends TransactionException {
    public OperationNotAllowedException() {
        super("Operation not allowed for this account.");
    }
    public OperationNotAllowedException(String message) {
        super(message);
    }
}
