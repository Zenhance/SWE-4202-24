package kenakata.payment;

import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment extends PaymentMethod{

    public CashOnDeliveryPayment(int w){super(w);}

    public CashOnDeliveryPayment() throws CheckoutException {
        super();

    }


}
