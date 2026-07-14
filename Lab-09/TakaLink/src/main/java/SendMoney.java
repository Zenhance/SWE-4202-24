public class SendMoney extends Transaction {

    public SendMoney(Wallet sender, Wallet receiver, double amount, String pin) {
        super(sender, receiver, amount, pin);
    }

    @Override
    public double fee() {
        return 5.0;
    }

    @Override
    protected void validate() throws TransactionException {
        if (sender instanceof MerchantWallet) throw new OperationNotAllowedException();
    }

    @Override
    protected void execute() throws TransactionException {
        sender.debit(amount + fee());
        receiver.credit(amount);
    }
}
