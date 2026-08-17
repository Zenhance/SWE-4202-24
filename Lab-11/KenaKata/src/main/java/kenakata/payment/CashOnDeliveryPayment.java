package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment extends PaymentMethod{
    public final long codMax = 15000;

    @Override
    public void authorise(long value) throws CodCeilingExceededException {
        if(value>codMax){
            throw new CodCeilingExceededException("This much amount cant be on cash on delivery");
        }
    }
}
