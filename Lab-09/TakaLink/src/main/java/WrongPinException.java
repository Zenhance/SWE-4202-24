public class WrongPinException extends TransactionException{
    public WrongPinException(){
        super("PIN is wrong");
    }
}
