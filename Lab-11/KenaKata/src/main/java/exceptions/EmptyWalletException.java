package kenakata.exceptions;

/** A mobile wallet's balance was too low to authorise the requested amount. */
public class EmptyWalletException extends PaymentDeclinedException {

    public EmptyWalletException(String message) {
        super(message);
    }
}
