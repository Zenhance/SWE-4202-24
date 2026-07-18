public class TopUp extends Transaction {
    public TopUp(Wallet payingWallet, Wallet receivingWallet, double amount, String PIN) {
        super(payingWallet, receivingWallet, amount, PIN);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    public void settle() throws TransactionException {
        if (!getPayingWallet().verifyPin(super.getPIN())) {
            throw new InvalidPinException("Wrong PIN");
        }
        getPayingWallet().debit(getAmount());
        getReceivingWallet().credit(getAmount());
    }
}
