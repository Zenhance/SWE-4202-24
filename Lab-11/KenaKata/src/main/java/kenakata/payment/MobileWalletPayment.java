package kenakata.payment;
import kenakata.exceptions.PaymentDeclinedException;

public class MobileWalletPayment implements PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException();
        }

        this.wallet = wallet;
    }

    public Wallet wallet() {
        return wallet;
    }
}
