public class OperationNotAllowedException extends TransactionException {

    public OperationNotAllowedException() {
        super("operation not allowed");
    }

    public OperationNotAllowedException(String message) {
        super(message);
    }
}