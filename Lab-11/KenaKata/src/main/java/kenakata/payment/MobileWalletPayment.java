package kenakata.payment;

public class MobileWalletPayment implements PaymentMethod{
    private Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        if (wallet == null)
            throw new IllegalArgumentException("Wallet cannot be null");
        this.wallet = wallet;
    }

    @Override
    public void authorise(int amount) {

    }
}
