package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod{
    private final int ceiling = 15_000;

    @Override
    public void authorise(int amount) throws CodCeilingExceededException {
        if (amount > ceiling)
            throw new CodCeilingExceededException("Cash on delivery ceiling exceeded");
    }
}
