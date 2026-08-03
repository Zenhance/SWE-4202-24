package kenakata.exceptions;

/**
 * A payment was declined. This is itself a {@link CheckoutException}; each payment method has
 * its own more specific sub-kind (empty wallet, card over limit, COD over ceiling) so a caller
 * can either catch this common shape or react to a particular payment's refusal.
 */
public class PaymentDeclinedException extends CheckoutException {

    public PaymentDeclinedException(String message) {
        super(message);
    }
}
