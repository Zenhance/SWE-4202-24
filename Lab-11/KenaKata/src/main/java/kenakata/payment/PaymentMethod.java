package kenakata.payment;

import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.EmptyWalletException;

public abstract class PaymentMethod {

    public int x;
    int m;
    public Wallet w;


    public PaymentMethod() {

    }

    public PaymentMethod(int m){
        this.m = m;}

    public PaymentMethod(Wallet w) {
        if(w == null)
            throw new CheckoutException("Amount field is empty");
        this.w = w;
    }

    public void authorise(int i) throws Exception {

        this.x = i;

        if(w != null) {
            if(w.balance() < i)
                throw new EmptyWalletException("Insufficient balance");
            w.amount -= i;
        }
    }
}
