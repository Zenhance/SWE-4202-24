public class WrongPinException extends TransactionException {
    public WrongPinException() {
        super("Incorrect PIN.");
    }
    public WrongPinException(String message) {
        super(message);
    }
}
