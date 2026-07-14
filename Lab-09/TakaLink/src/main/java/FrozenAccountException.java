package src.main.java;

public class FrozenAccountException extends TransactionException {
    public FrozenAccountException(String message) {
        super(message);
    }
}
