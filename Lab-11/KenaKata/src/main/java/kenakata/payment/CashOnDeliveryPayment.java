package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;
import kenakata.exceptions.PaymentDeclinedException;

public class CashOnDeliveryPayment implements PaymentMethod {

    private static final long COD_CEILING = 15000;

    @Override
    public void authorise(long amount)
            throws PaymentDeclinedException {

        if (amount <= 0) {
            throw new IllegalArgumentException();
        }

        if (amount > COD_CEILING) {
            throw new CodCeilingExceededException();
        }
    }
}