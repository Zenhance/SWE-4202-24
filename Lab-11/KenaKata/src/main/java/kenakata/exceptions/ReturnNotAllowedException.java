package kenakata.exceptions;

public class ReturnNotAllowedException extends CheckoutException{
    public ReturnNotAllowedException(String msg) {
        super(msg);
    }
}
