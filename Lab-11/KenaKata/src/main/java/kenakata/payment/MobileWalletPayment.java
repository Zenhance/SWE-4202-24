package kenakata.payment;
import kenakata.exceptions.EmptyWalletException;
import kenakata.exceptions.PaymentDeclinedException;



public abstract class MobileWalletPayment implements PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet){
        this.wallet=wallet;
    }

}
