public class FrozenAccountException extends TransactionException{
    FrozenAccountException(String message){
        super(message);
    }
}
