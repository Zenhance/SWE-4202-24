package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public interface PaymentMethod {
    public void authorise(long amount) throws PaymentDeclinedException;
}
