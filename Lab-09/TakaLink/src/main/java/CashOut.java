public class CashOut extends Transaction{
    private static final double FEE = 0.0185;
    public CashOut(Wallet sender, Wallet reciever, double amount, String pin) {
        super(sender, reciever, amount, pin);
    }
    @Override
    public double fee() {
        return FEE;
    }

    @Override
    public void validOperation() throws TransactionException {
        if(!sender.canCashOut())
            throw new OperationNotAllowedException();
        if(!(reciever instanceof AgentWallet))
            throw new OperationNotAllowedException();
    }

    @Override
    public void moveMoney() throws TransactionException {
        sender.debit(amount()+fee());
        reciever.credit(amount());

    }
}
