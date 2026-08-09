package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class MobileWalletPayment implements PaymentMethod {
    private Wallet wallet;
    public MobileWalletPayment(Wallet wallet) {
        this.wallet=wallet;
    }

    public void authorise(int amount) throws EmptyWalletException {
        if(wallet.balance()<amount) throw new EmptyWalletException("not enough balance in wallet");
        wallet.debit(amount);
    }
}
