package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;
import kenakata.exceptions.PaymentDeclinedException;

public class CashOnDeliveryPayment
        implements PaymentMethod {
    private static final long LIMIT = 15000;
    @Override
    public void authorise(long amount)
            throws PaymentDeclinedException {
        if(amount > LIMIT) {
            throw new CodCeilingExceededException("COD limit exceeded");
        }
    }
}