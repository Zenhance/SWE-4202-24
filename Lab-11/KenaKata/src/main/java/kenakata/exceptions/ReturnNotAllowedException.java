package kenakata.exceptions;

import kenakata.catalog.Returnable;

public class ReturnNotAllowedException extends CheckoutException{
    public ReturnNotAllowedException(String message){
        super(message);
    }
}
