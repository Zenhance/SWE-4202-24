package kenakata.payment;

public class MobileWalletPayment implements PaymentMethod{
    public Wallet wallet;
    public long amount;
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
        return wallet.balance;
    }
    @Override
    public void authorise(long amount)  {
        wallet.debit(amount);
    }
}
