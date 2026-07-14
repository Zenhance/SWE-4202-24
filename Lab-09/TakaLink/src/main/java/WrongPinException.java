public class WrongPinException extends TransactionRefused{
    public WrongPinException(String message) {
        super(message);
    }
}
