package kenakata.payment;
import kenakata.exceptions.EmptyWalletException;

public class MobileWalletPayment implements PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void authorise(long amount) throws EmptyWalletException {
        if (wallet.balance() < amount) {
            throw new EmptyWalletException("Insufficient funds in mobile wallet.");
        }
        wallet.withdraw(amount);
    }
}