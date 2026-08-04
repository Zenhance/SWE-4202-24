package kenakata.payment;

import kenakata.exceptions.CheckoutException;
public interface PaymentMethod {
    void authorise(long amount)
            throws CheckoutException;

}