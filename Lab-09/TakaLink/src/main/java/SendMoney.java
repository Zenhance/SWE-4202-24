public class SendMoney extends Transaction{
    public SendMoney(Wallet payingWallet, Wallet receivingWallet, double amount, String PIN) {
        super(payingWallet, receivingWallet, amount, PIN);
    }

    @Override
    public double fee() {
        return 5.0;
    }

    @Override
    public void settle() throws TransactionException {
        if (getPayingWallet() instanceof MerchantWallet)
            throw new OperationNotAllowedException("Operation not allowed");
        if (!getPayingWallet().verifyPin(super.getPIN())) {
            throw new InvalidPinException("Wrong PIN");
        }
        double FLAT_FEE = 5.0;
        getPayingWallet().debit(getAmount() + FLAT_FEE);
        getReceivingWallet().credit(getAmount());
    }
}
