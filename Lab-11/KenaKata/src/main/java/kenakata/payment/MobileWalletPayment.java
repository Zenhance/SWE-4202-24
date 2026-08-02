package kenakata.payment;

import kenakata.exceptions.CheckoutException;

public class MobileWalletPayment extends PaymentMethod {

    public MobileWalletPayment(Wallet w) {
        super(w);
    }
    public MobileWalletPayment() {
        throw new CheckoutException("Amount field is empty");
    }

}
