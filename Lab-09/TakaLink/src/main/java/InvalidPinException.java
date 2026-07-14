public class InvalidPinException extends TransactionException {

    public InvalidPinException() {
        super("Invalid PIN");
    }

    public InvalidPinException(String message) {
        super(message);
    }
}