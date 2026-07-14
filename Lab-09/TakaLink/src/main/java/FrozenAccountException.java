public class FrozenAccountException extends TransactionException {

    public FrozenAccountException() {
        super("Account frozen");
    }

    public FrozenAccountException(String message) {
        super(message);
    }
}