package kenakata.exceptions;

public class EmptyWalletException extends CheckoutException{
    public EmptyWalletException(){
        super("Wallet balance is insufficient");
    }
}
