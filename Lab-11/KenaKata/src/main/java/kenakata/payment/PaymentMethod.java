package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public interface PaymentMethod {

    void authorize(long amount) throws PaymentDeclinedException;
}
