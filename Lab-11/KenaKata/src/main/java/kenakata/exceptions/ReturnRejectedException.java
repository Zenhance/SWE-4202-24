package kenakata.exceptions;

public class ReturnRejectedException extends CheckoutException{
    public ReturnRejectedException(String message){
        super(message);
    }
}

// I guess I have to change the class name to ReturnNotAllowedException
