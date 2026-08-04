package kenakata.payment;

import kenakata.exceptions.*;

public class MobileWalletPayment implements PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void authorise(long amount) throws CheckoutException, EmptyWalletException{
        wallet.deduct(amount);
    }
}

