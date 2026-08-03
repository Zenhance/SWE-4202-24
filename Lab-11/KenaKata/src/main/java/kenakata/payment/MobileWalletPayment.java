package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class MobileWalletPayment implements PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void authorise(long amount) throws EmptyWalletException {
        if (amount > wallet.balance()) {
            throw new EmptyWalletException("Wallet balance insufficient");
        }
        wallet.debit(amount);
    }
}