public class WrongPinException extends TransactionException{
    public WrongPinException(){
        super("WRONG");
    }
}
