public class MerchantWallet extends Wallet{

    public MerchantWallet(String name, double balance, String PIN) {
        super(name, balance, PIN);
    }

    @Override
    public void debit(double amount) throws TransactionException {
        throw new OperationNotAllowedException("Operation not allowed");
    }
}
