package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public class MobileWalletPayment implements PaymentMethod {
    public MobileWalletPayment(Wallet wallet) {
    }

    public void authorise(int i) {
    }

    @Override
    public void authorise(long amount) throws PaymentDeclinedException {

    }
}
