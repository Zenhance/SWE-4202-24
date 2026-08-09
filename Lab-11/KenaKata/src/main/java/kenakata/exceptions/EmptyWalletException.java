package kenakata.exceptions;

public class EmptyWalletException extends PaymentDeclinedException {

    public EmptyWalletException() {
        super("Insufficient wallet balance");
    }
}