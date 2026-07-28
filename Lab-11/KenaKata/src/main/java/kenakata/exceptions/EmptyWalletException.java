package kenakata.exceptions;

public class EmptyWalletException extends PaymentException{
    public EmptyWalletException(String msg) {
        super(msg);
    }
}
