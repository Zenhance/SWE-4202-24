package kenakata.payment;

import kenakata.exceptions.CheckoutException;

public class CardPayment extends PaymentMethod{


    public CardPayment(int w) {
        super(w);
    }
    public CardPayment() throws CheckoutException {super();}

    public int remainingLimit() {
        return 0;
    }


}
