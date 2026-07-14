public class OperationNotAlllowedException extends TransactionException{

    public OperationNotAlllowedException(String message) {
        super("Operation Not Allowed");
    }
}
