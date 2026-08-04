package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

/** Pays by debiting a mobile wallet immediately; refused if the balance is too low. */
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
        wallet.debit(amount);
    }
}
