package kenakata.exception;

import java.nio.charset.CharacterCodingException;

public class ReturnNotAllowedException extends CheckoutException {
    public ReturnNotAllowedException(String message){
        super(message);

    }
}
