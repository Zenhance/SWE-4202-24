package kenakata.exceptions;

/**
 * Common parent for every business refusal in KenaKata (as opposed to a malformed request,
 * which is rejected at construction with an unchecked {@link IllegalArgumentException}).
 *
 * <p>A well-formed request that the business declines -- out of stock, a rejected coupon, a
 * declined payment, a return outside its window -- is modelled as a checked exception under
 * this one family, so a caller can catch every refusal uniformly as a {@code CheckoutException}
 * or handle a specific kind individually.
 */
public class CheckoutException extends Exception {

    public CheckoutException(String message) {
        super(message);
    }
}
