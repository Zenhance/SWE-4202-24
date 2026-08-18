package Refusals;

public class NoSpaceAvailableException extends RuntimeException {
    public NoSpaceAvailableException(String message) {
        super(message);
    }
}
