package kenakata.exceptions;

public class EmptyWalletException extends PaymentDeclinedException {
    public EmptyWalletException(){
        super("Wallet balance is insufficient.");
    }

}
