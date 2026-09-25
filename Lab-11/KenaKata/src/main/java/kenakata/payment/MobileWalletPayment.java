package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;
import kenakata.exceptions.PaymentDeclinedException;

import java.util.EmptyStackException;

public class MobileWalletPayment implements PaymentMethod{
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void pay() {

    }

    @Override
    public void authorise(int amount) throws EmptyWalletException{
        if(wallet !=null && wallet.balance()<amount){
            throw new EmptyWalletException("Insufficient Balance");
        }

    }
}
