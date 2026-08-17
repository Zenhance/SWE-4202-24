package kenakata.exceptions;


import kenakata.exceptions.CheckoutException;

public class NotInsurableException extends CheckoutException {
    public NotInsurableException(String message) {
        super(message);
    }
}
