public class TopUp extends Transaction{

    public TopUp (Wallet fromId, Wallet ToId, double amount, String pin)
    {
        super(fromId, toId, amount, pin);
    }
    @Override
    public double fee()
    {
        return 0.0;
    }
    @Override
    public void validateOperation() throws OperationNotAllowedException
    {
        if(!fromId.canSendMoney())
            throw new OperationNotAllowedException();
    }
    @Override
    public void moveMoney() throws TransactionException
    {
        fromId.debit(amount);
        toId.credit(amount);
    }
}
