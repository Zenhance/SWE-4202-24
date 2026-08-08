package kenakata.exceptions;

public class PaymentException extends CheckOutException {
    public PaymentException(String message){
        super(message);
    }
}
