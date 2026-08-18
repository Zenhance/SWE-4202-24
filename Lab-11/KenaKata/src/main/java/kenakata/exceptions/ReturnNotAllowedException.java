package kenakata.exceptions;

public class ReturnNotAllowedException extends CheckoutException {

    public ReturnNotAllowedException() {
        super("Return not allowed");
    }
}