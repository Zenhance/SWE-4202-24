package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;
import kenakata.exceptions.PaymentDeclinedException;

public class CashonDeliveryPayment implements PaymentMethod{
    @Override
    public void authorise(long amount) throws CodCeilingExceededException {
        if(amount > 15000) {
            throw new CodCeilingExceededException("");
        }
    }
}
