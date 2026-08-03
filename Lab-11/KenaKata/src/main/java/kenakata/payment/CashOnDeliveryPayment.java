package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod
{
    public static final long COD_CEILING = 15000;

    @Override
    public void authorise(long amount) throws CodCeilingExceededException
    {
        if(amount>COD_CEILING)
            throw new CodCeilingExceededException("Cash on delivery ceiling exceeded");
    }
}