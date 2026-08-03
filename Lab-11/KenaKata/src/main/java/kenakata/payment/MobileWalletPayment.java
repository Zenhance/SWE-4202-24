package kenakata.payment;

import kenakata.Wallet;
import kenakata.exceptions.EmptyWalletException;
import kenakata.exceptions.PaymentDeclinedException;
import kenakata.payment.PaymentMethod;

public class MobileWalletPayment extends PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void authorise(long value) throws EmptyWalletException {
        wallet.debit(value);
    }
}
