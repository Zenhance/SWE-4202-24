package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public interface PaymentMethod {
    void authorise(long amount) throws PaymentDeclinedException;

    default void validate(long amount) throws PaymentDeclinedException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}
