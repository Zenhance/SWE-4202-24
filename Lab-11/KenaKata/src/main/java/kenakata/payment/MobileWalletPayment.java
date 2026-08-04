package kenakata.payment;

import kenakata.exceptions.*;

public class MobileWalletPayment implements PaymentMethod{
    private Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        if (wallet == null)
            throw new IllegalArgumentException("Wallet cannot be null");
        this.wallet = wallet;
    }

    @Override
    public void authorise(int amount) throws EmptyWalletException {
        if (amount > wallet.balance())
            throw new EmptyWalletException("Not enough balance");

       wallet.debit(amount);
    }
}
