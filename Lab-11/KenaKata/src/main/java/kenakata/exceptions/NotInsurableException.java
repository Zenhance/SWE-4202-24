package kenakata.exceptions;

public class NotInsurableException extends CheckOutExceptions{
    public NotInsurableException() {
        super("Item cannot be insured.");
    }

}
