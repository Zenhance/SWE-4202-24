package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;
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
    public void authorise(long amount) throws EmptyWalletException
    {
        if(wallet.balance()<amount)
            throw new EmptyWalletException("Not enough balance");
        wallet.debit(amount);
    }
}