package kenakata.exceptions;

public class EmptyWalletException extends PaymentDeclineException {
    public EmptyWalletException(String message) {
        super(message);
    }
}
