package kenakata.payment;

import kenakata.exceptions.CheckoutException;

public class CashOnDeliveryPayment extends PaymentMethod{

    public CashOnDeliveryPayment(Wallet w) {
        super(w);
    }

    public CashOnDeliveryPayment() throws CheckoutException {super();}
}
