package src.main.java;

public class OperationNotAllowedException extends TransactionException {
    public OperationNotAllowedException(String message) {
        super(message);
    }
}