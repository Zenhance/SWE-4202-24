public class CashOut extends Transaction {

    public CashOut(Wallet fromId, Wallet toId, double amount, String pin) {

        super(TransactionType.CASHOUT, amount, fromId, toId, pin);

    }

    @Override
    public double fee() {
        return amount() * 0.0185;
    }
    @Override
    protected void validateSpecific()
            throws OperationNotAllowedException {

        if (!(toId() instanceof AgentWallet)) {
            throw new OperationNotAllowedException();
        }
    }
    @Override
    protected void moveMoney()
            throws TransactionException {

        fromId().debit(amount() + fee());

        toId().credit(amount() + fee());
    }
}
