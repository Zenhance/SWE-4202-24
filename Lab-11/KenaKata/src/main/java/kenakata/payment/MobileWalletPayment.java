package kenakata.payment;

public class MobileWalletPayment implements PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        this.wallet = wallet;
    }
    @Override
    public void authorise(int amount) {

    }
}
