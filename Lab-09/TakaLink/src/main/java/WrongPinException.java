public class WrongPinException extends TransactionException{
    public WrongPinException(String msg){
        super("WRONG");
    }
}
