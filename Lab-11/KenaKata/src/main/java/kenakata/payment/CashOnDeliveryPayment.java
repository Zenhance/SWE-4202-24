package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod {
   private static final long COD_CEILING = 15000;

    @Override
    public void authorize(long amount) throws CodCeilingExceededException {
        if(amount>COD_CEILING)
            throw new CodCeilingExceededException("Cash On Delivery ceiling exceeded.");
    }
}
