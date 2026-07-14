public class InsufficientBalanceException extends TransactionException{

    public InsufficientBalanceException(String msg){
        super(msg);
    }
}
