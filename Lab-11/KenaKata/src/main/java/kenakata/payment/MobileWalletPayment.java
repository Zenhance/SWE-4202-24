package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public final class MobileWalletPayment implements PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet must not be null");
        }
        this.wallet = wallet;
    }

    @Override
    public void authorise(long amount) throws PaymentDeclinedException {
        wallet.debit(amount);
    }
}