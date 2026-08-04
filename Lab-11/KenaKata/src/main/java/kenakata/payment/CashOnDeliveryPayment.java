package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;
import kenakata.exceptions.PaymentDeclinedException;

public class CashOnDeliveryPayment implements PaymentMethod{
    private static final int cod=15000;
    @Override
    public void authorise(long amount) throws CodCeilingExceededException {
        if(amount>cod)
            throw new CodCeilingExceededException("Invalid");

    }
}
