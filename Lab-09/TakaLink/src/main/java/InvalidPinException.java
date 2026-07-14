public class InvalidPinException extends Exception {
    public InvalidPinException() {
        super("Pin is wrong or invalid");
    }
}
