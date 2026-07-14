public class OperationNotAllowedException extends TransactionException{
    public OperationNotAllowedException(String message){
        super(message);
    }
}

