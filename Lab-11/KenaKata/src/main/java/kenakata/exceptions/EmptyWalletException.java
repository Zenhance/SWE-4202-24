package kenakata.exceptions;

public class EmptyWalletException extends PaymentDeclinedException  {
    public EmptyWalletException(String message) {
        super(message);
    }
}
