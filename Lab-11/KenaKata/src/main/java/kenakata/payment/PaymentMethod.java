package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public interface PaymentMethod {
    void authorise(long amount)throws PaymentDeclinedException;
}
