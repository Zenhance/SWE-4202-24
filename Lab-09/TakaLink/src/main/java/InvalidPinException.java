package src.main.java;

public class InvalidPinException extends TransactionException{
    public InvalidPinException(String message){
        super(message);
    }
}
