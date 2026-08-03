package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;
@FunctionalInterface
public interface PaymentMethod {

    void authorise(long amount)
            throws PaymentDeclinedException;
}