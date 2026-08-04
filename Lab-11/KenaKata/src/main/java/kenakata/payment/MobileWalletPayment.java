package kenakata.payment;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.EmptyWalletException;

public class MobileWalletPayment implements PaymentMethod{
    private final Wallet wallet;
    public MobileWalletPayment(Wallet wallet){
        this.wallet=wallet;
    }

    @Override
    public void authorise(long amount) throws EmptyWalletException {
        if(wallet.balance()<0){
            throw new EmptyWalletException("Wallet balance insufficient");
        }
        wallet.deduct(amount);

    }
}
