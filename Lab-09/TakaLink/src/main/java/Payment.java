public class Payment extends Transaction {
    public Payment(Wallet fromId, Wallet toId, double amount, String pin) {
        super(TransactionType.PAYMENT, amount, fromId, toId, pin);
    }
    @Override
    public double fee() {
        return 0.0;
    }
    @Override
    protected void validateSpecific()
            throws OperationNotAllowedException {

        if (!(toId() instanceof MerchantWallet)) {
            throw new OperationNotAllowedException();
        }
    }
    @Override
    protected void moveMoney()
            throws TransactionException {

        fromId().debit(amount());

        toId().credit(amount());
    }

}
