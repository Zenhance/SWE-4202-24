public class FrozenAccountException extends TransactionException{
    protected FrozenAccountException(String message) {
        super(message);
    }
}
