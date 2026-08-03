package kenakata.exceptions;

public class EmptyWalletException extends PaymentException{
    EmptyWalletException(String message){
        super(message);
    }
}
