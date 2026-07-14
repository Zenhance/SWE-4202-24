public class OperationNotAllowedException extends TransactionExceptions{

    public OperationNotAllowedException(){
        super("Operation is not allowed");
    }
}
