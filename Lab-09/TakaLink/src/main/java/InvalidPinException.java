public class InvalidPinException extends TransactionException {
    public InvalidPinException(String id) { super("Invalid PIN: " + id); }
}