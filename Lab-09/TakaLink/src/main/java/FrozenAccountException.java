public class FrozenAccountException extends TransactionException {

    public FrozenAccountException() {
        super();
    }

    public FrozenAccountException(String message) {
        super(message);
    }
}
