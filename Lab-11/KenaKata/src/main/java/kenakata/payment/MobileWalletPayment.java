package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public class MobileWalletPayment implements PaymentMethod
{
    private Wallet wallet;

    public MobileWalletPayment(Wallet wallet)
    {
        if(wallet==null)
            throw new IllegalArgumentException("Wallet can not be null");
        this.wallet = wallet;
    }

    @Override
    public void authorise(long amount) throws PaymentDeclinedException
    {
        wallet.debit(amount);
    }
}