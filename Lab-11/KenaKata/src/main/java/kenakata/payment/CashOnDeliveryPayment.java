package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod{
    public static final int COD_CEILING=15000;

    public void authorise(int amount) throws CodCeilingExceededException {
        if(amount>COD_CEILING) throw new CodCeilingExceededException("amount cannot be larger than Cod ceilling amount");
    }
}
