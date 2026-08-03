package kenakata.exceptions;

public class EmptyWallertException extends PaymentDeclinedException {
    public EmptyWallertException(String message){
        super(message);
    }
}
