package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public class MobileWalletPayment implements PaymentMethod{
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        if(wallet==null)
            throw new IllegalArgumentException("Invalid");
        this.wallet = wallet;
    }



    @Override
    public void authorise(long amount) throws PaymentDeclinedException {
        wallet.debit((int) amount);
    }
}
