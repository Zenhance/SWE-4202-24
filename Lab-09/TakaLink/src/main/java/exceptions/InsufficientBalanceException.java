package exceptions;

public class InsufficientBalanceException
        extends TransactionException {
    public InsufficientBalanceException (String message){
        super (message);
    }
}
