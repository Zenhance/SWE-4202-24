package kenakata.payment;
import kenakata.exceptions.EmptyWalletException;

public class MobileWalletPayment implements PaymentMethod{
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet){
        if(wallet==null){
            throw new IllegalArgumentException();
        }
        this.wallet=wallet;
    }

    public void authorise(int amount)throws EmptyWalletException{
        if(wallet.balance()<amount){
            throw new EmptyWalletException();
        }
        wallet.deduct(amount);
    }
}
