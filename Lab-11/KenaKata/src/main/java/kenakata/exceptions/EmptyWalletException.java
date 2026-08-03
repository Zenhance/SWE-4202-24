package kenakata.exceptions;

public class EmptyWalletException extends CheckoutException {
    public EmptyWalletException(String message){
        super(message);
    }
}
