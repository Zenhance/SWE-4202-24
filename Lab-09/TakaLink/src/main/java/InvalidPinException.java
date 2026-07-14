package main.java;

public class InvalidPinException extends TransactionException{
    public InvalidPinException(){
        super("Invalid pin");
    }
}
