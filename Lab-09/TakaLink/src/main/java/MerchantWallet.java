public class MerchantWallet extends Wallet{


    protected MerchantWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }

    @Override
    protected double getDailylimit() {
        return 0;
    }

    @Override
    protected boolean canPay() {
        return true;
    }
}
