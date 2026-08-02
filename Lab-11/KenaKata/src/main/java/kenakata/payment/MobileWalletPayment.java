package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;
public class MobileWalletPayment implements PaymentMethod {
    private Wallet wallet;
    public MobileWalletPayment(Wallet wallet){
        if(wallet==null){
            throw new IllegalArgumentException("Wallet cannot be null");
        }
        this.wallet=wallet;
    }

    @Override
    public void authorise(long amount) throws EmptyWalletException{
        if(amount>wallet.balance()){
            throw new EmptyWalletException("Insufficient balance");
        }
        wallet.deduct(amount);
    }

}
