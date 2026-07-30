package kenakata;

public class PaymentDeclinedException extends Exception{
    PaymentDeclinedException(String message){
        super(message);
    }
}
