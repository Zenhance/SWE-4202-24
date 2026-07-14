public class FrozenAccountException extends TransactionException{
    public FrozenAccountException(){
        super("Frozen Account");
    }
}
