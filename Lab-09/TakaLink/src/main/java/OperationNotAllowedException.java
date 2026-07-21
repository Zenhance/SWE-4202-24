public class OperationNotAllowedException extends TransactionException {
    protected OperationNotAllowedException(String message) {
        super(message);
    }
}
