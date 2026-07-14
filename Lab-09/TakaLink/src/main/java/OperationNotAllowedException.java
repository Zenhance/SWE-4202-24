public class OperationNotAllowedException extends TransactionException{
    public OperationNotAllowedException() {
        super("Operation not allowed");
    }
}
