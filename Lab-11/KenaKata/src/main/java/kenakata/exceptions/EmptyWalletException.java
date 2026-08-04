package kenakata.exceptions;

public final class EmptyWalletException extends CheckoutException {

    public EmptyWalletException(String message) {
        super(message);
    }
}
