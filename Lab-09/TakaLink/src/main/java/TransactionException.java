package src.main.java;

public abstract class TransactionException extends Exception{
    private String message;

    public TransactionException(String message){
        super(message);
    }
}
