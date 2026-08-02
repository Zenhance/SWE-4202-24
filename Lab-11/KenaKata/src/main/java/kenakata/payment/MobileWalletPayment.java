package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public final class MobileWalletPayment implements PaymentMethod {

    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("wallet must not be null");
        }
        this.wallet = wallet;
    }

    @Override
    public void authorise(long amount) throws EmptyWalletException {
        if (amount > wallet.balance()) {
            throw new EmptyWalletException("");
        }
        wallet.debit(amount);
    }
}
