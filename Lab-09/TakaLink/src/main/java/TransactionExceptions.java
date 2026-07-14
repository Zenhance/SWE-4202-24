public abstract class TransactionExceptions extends Exception{
    private String message;

    public TransactionExceptions(String message){
        super(message);
    }
}
