package kenakata.exceptions;

public class PaymentDeclinedException extends EmptyWalletException {
    public PaymentDeclinedException(String message){
        super(message);
    }
}
