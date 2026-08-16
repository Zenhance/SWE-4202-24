package kenakata.payment;

public class MobileWalletPayment extends PaymentMethod {
    Wallet wallet;
    public MobileWalletPayment(Wallet wallet) {
        this.wallet = wallet;
    }

    public void authorise(int amount) {
        if(amount < 0) throw new IllegalArgumentException() ;
        if(amount<=this.amount) this.amount-=amount;
    }}
