public class FrozenAccountException extends TransactionException{
    public  FrozenAccountException(String walletId){
        super("Wallet "+ walletId+" is frozen");
    }
}
