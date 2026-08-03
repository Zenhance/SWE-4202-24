package kenakata.payment;

public class MobileWalletPayment implements PaymentMethod{
    public Wallet wallet;
    public MobileWalletPayment(Wallet wallet) {
        if (wallet==null)
            throw new IllegalArgumentException();
        this.wallet = wallet;
    }
    public Wallet getWallet() {
        return wallet;
    }
    @Override
    public long remainingLimit() {
        return 0;
    }
    @Override
    public void authorise(long amount)  {
        wallet.debit(amount);
    }
}
