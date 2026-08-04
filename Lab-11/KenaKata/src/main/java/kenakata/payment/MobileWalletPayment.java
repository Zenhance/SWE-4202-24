package kenakata.payment;

import kenakata.exceptions.CheckoutException;

public class MobileWalletPayment implements PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet){
        if(wallet == null){

            throw new IllegalArgumentException("Wallet required");
        }
        this.wallet = wallet;
    }

    @Override
    public void authorise(long amount)
            throws CheckoutException{
        wallet.debit(amount);
    }

}