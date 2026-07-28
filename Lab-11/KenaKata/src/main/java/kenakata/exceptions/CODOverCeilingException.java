package kenakata.exceptions;

public class CODOverCeilingException extends PaymentException{
    public CODOverCeilingException(String msg) {
        super(msg);
    }
}
