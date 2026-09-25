package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public interface PaymentMethod {
    public void pay();
    public void authorise(int amount) throws PaymentDeclinedException;
}
