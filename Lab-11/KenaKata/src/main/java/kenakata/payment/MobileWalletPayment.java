package kenakata.payment;
import kenakata.exceptions.EmptyWalletException;

public final class MobileWalletPayment implements PaymentMethod{
    private final Wallet wallet;
    public MobileWalletPayment(Wallet wallet){
        if(wallet == null){
            throw new IllegalArgumentException("Wallet must not be null");
        }
        this.wallet = wallet;
    }
}
