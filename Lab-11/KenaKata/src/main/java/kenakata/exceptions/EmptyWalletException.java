package kenakata.exceptions;

public class EmptyWalletException extends CheckoutException{
    public EmptyWalletException(String Message){
        super("Wallet balance is insufficient");
    }
}
