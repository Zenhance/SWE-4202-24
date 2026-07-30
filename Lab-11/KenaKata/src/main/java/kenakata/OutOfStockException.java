package kenakata;

import kenakata.exceptions.CheckoutException;

public class OutOfStockException extends CheckoutException {
    OutOfStockException(String message){
        super(message);
    }
}
