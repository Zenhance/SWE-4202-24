package src.main.java;

public class InvalidPinException extends TransactionException{
    public InvalidPinException(){
        super("Invalid Pin");
    }

}
