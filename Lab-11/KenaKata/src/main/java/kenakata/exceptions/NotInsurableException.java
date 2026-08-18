package kenakata.exceptions;

public class NotInsurableException extends CheckoutException {

    public NotInsurableException() {
        super("Item is not insurable");
    }
}