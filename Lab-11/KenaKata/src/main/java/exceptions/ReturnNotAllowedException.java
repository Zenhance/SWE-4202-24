package kenakata.exceptions;

/**
 * A return was refused: the line cannot be returned at all, it was already returned, or the
 * request came in after the line's return window closed.
 */
public class ReturnNotAllowedException extends CheckoutException {

    public ReturnNotAllowedException(String message) {
        super(message);
    }
}
