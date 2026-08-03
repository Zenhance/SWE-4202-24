package kenakata.payment;
import kenakata.exceptions.EmptyWalletException;

import java.awt.*;

public final class MobileWalletPayment implements PaymentMethod{
    private final Wallet wallet;
    public MobileWalletPayment(Wallet wallet){
        if(wallet == null){
            throw new IllegalArgumentException("Wallet must not be null");
        }
        this.wallet = wallet;
    }
    @Override
    public void validate(long amount) throws EmptyWalletException {
        PaymentMethod.requireNonNegative(amount);
        wallet.ensureCanDebit(amount);
    }
    @Override
    public void authorise(long amount) throws EmptyWalletException {
        validate(amount);
        wallet.debit(amount);
    }
}
