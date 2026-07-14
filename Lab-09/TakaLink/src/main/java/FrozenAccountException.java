package src.main.java;

public class FrozenAccountException extends TransactionException{
    public FrozenAccountException(){
        super("Account has been frozen");
    }
}
