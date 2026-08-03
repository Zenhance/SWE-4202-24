package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod {
    private static long COD_CEILING = 15000;

    @Override
    public void authorise(long amount) throws CodCeilingExceededException {
        if (amount > COD_CEILING) {
            throw new CodCeilingExceededException("Grand total exceeds maximum COD limit of 15000");
        }
    }
}