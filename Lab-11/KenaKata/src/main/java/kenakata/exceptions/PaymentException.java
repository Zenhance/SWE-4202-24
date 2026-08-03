package kenakata.exceptions;

public abstract class PaymentException extends BusinessException{
    public PaymentException(String message){
        super(message);
    }
}
