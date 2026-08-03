package kenakata;

public class EmptyWalletException extends CheckoutException{
    public EmptyWalletException(String message){
        super(message);
    }
}
