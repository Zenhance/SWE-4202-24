package kenakata.payment;

import kenakata.exceptions.CheckoutException;

public class MobileWalletPayment implements PaymentMethod{
    private final Wallet wallet;
    public MobileWalletPayment(Wallet wallet){
        if(wallet == null){
            throw new IllegalArgumentException("Wallet must not be null");
        }
        this.wallet = wallet;
    }
    @Override
    public void validate(long amount) throws CheckoutException {
        PaymentMethod.requireNonNegative(amount);
        wallet.canBeDebited(amount);
    }
    @Override
    public void authorise(long amount) throws CheckoutException {
        validate(amount);
        wallet.debit(amount);
    }
}
