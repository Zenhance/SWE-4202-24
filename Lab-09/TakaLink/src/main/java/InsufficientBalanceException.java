public class InsufficientBalanceException extends TransactionException{
        InsufficientBalanceException(String message){
            super(message);
        }
}
