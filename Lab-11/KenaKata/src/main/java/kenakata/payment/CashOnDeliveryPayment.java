package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod {

    private static final long CEILING = 15_000;

    @Override
    public void authorise(long amount) throws CodCeilingExceededException {
        if (amount > CEILING) {
            throw new CodCeilingExceededException("COD ceiling of " + CEILING + " exceeded by charge of " + amount);
        }
    }
}