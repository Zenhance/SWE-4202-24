package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;
import kenakata.exceptions.PaymentDeclinedException;

public class MobileWalletPayment implements PaymentMethod {
    private Wallet wallet;
    public MobileWalletPayment(Wallet wallet) {
        this.wallet = wallet;
    }
    @Override
    public void authorise(long amount)
            throws PaymentDeclinedException {
        if(amount > wallet.balance()) {
            throw new EmptyWalletException("Insufficient wallet balance");
        }
        wallet.reduce(amount);
    }
}