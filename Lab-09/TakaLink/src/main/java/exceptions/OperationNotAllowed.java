package exceptions;

public class OperationNotAllowed extends TransactionException{
    public OperationNotAllowed(String message){
        super (message);
    }
}
