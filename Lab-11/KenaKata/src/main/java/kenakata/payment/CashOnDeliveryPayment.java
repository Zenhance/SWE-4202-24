package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod{
    private static final long LIMIT=15000;

    @Override
    public void authorise(long amount) throws CodCeilingExceededException {
        if(amount>LIMIT){
            throw new CodCeilingExceededException();
        }
    }
}
