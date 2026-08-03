public class OperationNotAllowedException extends TransactionException{
    OperationNotAllowedException(String message){
        super(message);
    }
}
