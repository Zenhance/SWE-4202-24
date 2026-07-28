package kenakata.payment;

import kenakata.exceptions.CheckoutException;

public abstract class PaymentMethod {

    int m;
    Wallet w;


    public PaymentMethod() throws CheckoutException {
        throw new CheckoutException("Amount field is empty");
    }

    public PaymentMethod(int m){
        this.m = m;}

    public PaymentMethod(Wallet w) {
        this(w.balance());
    }

    public void authorise(int i) {
    }
}
