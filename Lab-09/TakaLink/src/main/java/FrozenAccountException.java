public class FrozenAccountException extends TransactionRefused {
    public FrozenAccountException(String message) {
        super(message);
    }

}
