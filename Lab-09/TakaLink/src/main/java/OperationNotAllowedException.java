public class OperationNotAllowedException extends TransactionException {

    public OperationNotAllowedException() {
        super();
    }

    public OperationNotAllowedException(String message) {
        super(message);
    }

}
