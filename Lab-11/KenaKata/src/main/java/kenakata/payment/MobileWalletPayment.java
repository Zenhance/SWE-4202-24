package kenakata.payment;

public class MobileWalletPayment extends PaymentMethod{
    private Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        this.wallet = wallet;
    }
}
