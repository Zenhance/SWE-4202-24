package kenakata.exceptions;

public class ReturnNotAllowedException extends RuntimeException {
    public ReturnNotAllowedException(String message) {
        super(message);
    }
}
