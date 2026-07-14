package src.main.java;

public class OperationNotAllowedException extends TransactionException{
    public OperationNotAllowedException(){
        super("Operation is not Allowed currently");
    }

}
