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

    @Override
    public void authorise(long amount)
            throws PaymentDeclinedException {

        if (amount <= 0) {
            throw new IllegalArgumentException();
        }

        wallet.debit(amount);
    }

    public Wallet wallet() {
        return wallet;
    }
}
