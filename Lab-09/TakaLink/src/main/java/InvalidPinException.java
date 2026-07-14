public class InvalidPinException extends TransactionException {

    public InvalidPinException() {
        super();
    }

    public InvalidPinException(String message) {
        super(message);
    }

}
