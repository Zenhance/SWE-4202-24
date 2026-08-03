package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;
import kenakata.exceptions.PaymentDeclinedException;

public final class MobileWalletPayment implements PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet is required");
        }
        this.wallet = wallet;
    }

    public Wallet wallet() {
        return wallet;
    }

    @Override
    public void validate(long amount) throws EmptyWalletException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (amount > wallet.balance()) {
            throw new EmptyWalletException("Wallet balance is too low");
        }
    }

    @Override
    public void authorise(long amount) throws PaymentDeclinedException {
        validate(amount);
        wallet.debit(amount);
    }
}
