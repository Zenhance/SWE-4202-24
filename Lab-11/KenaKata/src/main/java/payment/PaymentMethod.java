package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

/**
 * A way to pay. An order hands the chosen method a single amount and asks it to authorise that
 * amount; the three real implementations (wallet, card, cash on delivery) are otherwise
 * unrelated, but a caller can hold any of them behind this one type.
 */
public interface PaymentMethod {

    /** Authorises {@code amount}, moving money if it can, or throwing the specific refusal. */
    void authorise(long amount) throws PaymentDeclinedException;
}
