public class OperationNotAllowedException extends TransactionException {
    public OperationNotAllowedException(String id) { super("Operation not allowed: " + id); }
}