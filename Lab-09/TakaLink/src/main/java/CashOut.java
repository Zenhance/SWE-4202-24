public class CashOut extends Transaction {
    public CashOut(Wallet sender, Wallet receiver, double amount, String pin) {
        super(sender, receiver, amount, pin);
    }

    @Override
    public double fee() {
        return amount * 0.0185;
    }

    @Override
    protected void validate() throws TransactionException {
        if (sender instanceof MerchantWallet) throw new OperationNotAllowedException();

        if (!(receiver instanceof AgentWallet)) throw new OperationNotAllowedException();
    }

    @Override
    protected void execute() throws TransactionException {
        sender.debit(amount + fee());
        receiver.credit(amount + fee());
    }
}
