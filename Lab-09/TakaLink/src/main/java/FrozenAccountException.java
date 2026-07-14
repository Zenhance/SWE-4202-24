public class FrozenAccountException extends TransactionException{
    public FrozenAccountException(String msg){
        super("Account is frozen");
    }

}
