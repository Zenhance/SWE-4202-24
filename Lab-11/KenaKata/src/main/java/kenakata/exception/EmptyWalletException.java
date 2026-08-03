package kenakata.exception;

public class EmptyWalletException extends PaymentDeclinedException{
    public EmptyWalletException(String message){
        super(message);
    }
}
