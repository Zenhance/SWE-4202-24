package kenakata.payment;

import kenakata.exceptions.EmptyWalletException;

public class MobileWalletPayment extends PaymentMethod {
    Wallet wallet;
    public MobileWalletPayment(Wallet wallet) {
        this.wallet = wallet;
    }

    public void authorise(int amount) throws EmptyWalletException {
        if(amount < 0) throw new IllegalArgumentException() ;
        if(amount> wallet.amount) throw new EmptyWalletException();
        wallet.amount -= amount;
    }}
