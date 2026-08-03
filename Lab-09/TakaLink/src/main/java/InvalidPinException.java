public class InvalidPinException extends TransactionException{
    InvalidPinException(String message){
        super(message);
    }
}
