public class OperationNotAllowedException extends TransactionException{
    public OperationNotAllowedException(){
        super("operation not allowed for this wallet");
    }

}
