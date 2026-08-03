package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;

public final class CashOnDeliveryPayment implements PaymentMethod {

    private static final long CEILING = 15_000;

    @Override
    public void authorise(long amount) throws CodCeilingExceededException {
        if (amount > CEILING) {
            throw new CodCeilingExceededException(
                    "Amount Tk " + amount + " exceeds the COD ceil of Tk " + CEILING);
        }
    }
}
