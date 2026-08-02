package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class MobileWalletPayment implements PaymentMethod {
    private Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet can't be null.");
        }
        this.wallet = wallet;
    }

    @Override
    public void authorize(long amount) throws EmptyWalletException {
        wallet.debit(amount);
    }

}
