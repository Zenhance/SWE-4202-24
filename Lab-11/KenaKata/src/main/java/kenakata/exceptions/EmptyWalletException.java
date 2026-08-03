package kenakata.exceptions;

public class EmptyWalletException extends PaymentDeclinedException{

    public EmptyWalletException(){
        super();
    }
    public EmptyWalletException(String message){
        super(message);
    }
}