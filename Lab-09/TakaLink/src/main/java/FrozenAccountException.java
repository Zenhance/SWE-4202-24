public class FrozenAccountException extends TransactionException{
    public FrozenAccountException(){
        super("Wallet is frozen");
    }
}
