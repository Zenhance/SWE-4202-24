package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public class CashOnDeliveryPayment implements PaymentMethod{
    @Override
    public void pay() {
    }

    @Override
    public void authorise(int amount) throws PaymentDeclinedException {

    }
}
