public class TransactionException extends Exception{
    TransactionException(String message){
        super("Invalid transaction.");
    }
}
