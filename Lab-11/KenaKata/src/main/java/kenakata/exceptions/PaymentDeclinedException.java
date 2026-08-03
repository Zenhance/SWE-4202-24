package kenakata.exceptions;

public class PaymentDeclinedException extends Exception{

    public PaymentDeclinedException(){
        super();
    }
    public PaymentDeclinedException(String message){
        super(message);
    }
}