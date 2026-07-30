package kenakata;

public class EmptyWalletException extends PaymentDeclinedException{
    EmptyWalletException(String message){
        super(message);
    }
}
