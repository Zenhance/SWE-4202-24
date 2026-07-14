public class MerchantWallet extends Wallet {
    public MerchantWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }
    @Override
    public double dailyLimit() {
        return 0;
    }
    @Override
    public boolean allows(TransactionType type) {

        return type != TransactionType.SEND
                && type != TransactionType.CASHOUT;
    }
}
