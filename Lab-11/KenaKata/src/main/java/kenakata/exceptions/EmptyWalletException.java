package kenakata.exceptions;

public class EmptyWalletException extends PaymentDeclinedException {
    public EmptyWalletException(String msg) {
        super(msg);
    }
}
