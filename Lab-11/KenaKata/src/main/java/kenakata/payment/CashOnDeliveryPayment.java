package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod{
    private static final long MAX_COD_AMOUNT=15000;

    @Override
    public void authorise(long amount) throws CodCeilingExceededException{
        if(amount>MAX_COD_AMOUNT){
            throw new CodCeilingExceededException("Cash on delivery is available is only upto 15000 taka");
        }
    }
}
