public class InsufficientBalanceException extends TransactionException{
    public InsufficientBalanceException(){
        super("Insufficient balance");
    }
}
