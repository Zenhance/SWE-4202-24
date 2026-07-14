package main.java;

public class FrozenAccountException extends TransactionException{
    public FrozenAccountException(){
        super("Account is frozen");
    }
}
