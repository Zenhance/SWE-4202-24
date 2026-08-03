package kenakata.payment;

import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment extends PaymentMethod{

    public CashOnDeliveryPayment(int w){super(w);}

    public CashOnDeliveryPayment() throws CheckoutException {
        super();

    }

    @Override
    public void authorise(int p) throws Exception{
        if(p > 15000)
            throw new CodCeilingExceededException("Over the cod limit");
        super.authorise(p);
    }
}
