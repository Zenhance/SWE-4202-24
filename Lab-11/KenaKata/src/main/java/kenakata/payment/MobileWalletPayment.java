package kenakata.payment;

public class MobileWalletPayment implements PaymentMethod{
    public MobileWalletPayment(Wallet wallet) {
        super();
    }

    @Override
    public int remainingLimit() {
        return 0;
    }

    @Override
    public void authorise(int i) {

    }
}
