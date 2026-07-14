public class InvalidPinException extends Exception {
    public InvalidPinException(String pin) {
        super("Invalid Pin: " + pin);
    }
}
