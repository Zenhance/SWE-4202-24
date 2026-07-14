public class InvalidPinException extends TransactionException{
    public InvalidPinException(String msg){
        super("WRONG");
    }
}
