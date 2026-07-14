public class SendMoney extends Transaction{
    protected static final double FEE = 5.0;
    public SendMoney(Wallet sender, Wallet reciever, double amount, String pin) {
        super(sender, reciever, amount, pin);
    }

    @Override
    public double fee() {
        return FEE;
    }

    @Override
    public void validOperation() throws TransactionException {
        if(!sender().canSend())
            throw new OperationNotAllowedException();

    }

    @Override
    public void moveMoney() throws TransactionException {
        sender().debit(amount()+fee());
        reciever().credit(amount());

    }
}
