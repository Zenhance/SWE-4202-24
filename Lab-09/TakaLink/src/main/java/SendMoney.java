public class SendMoney extends Transaction
{
    private static final double FEE = 5.0;

    public SendMoney(Wallet fromId, Wallet toId, double amount, String pin)
    {
        super(fromId, toId, amount, pin);
    }

    @Override
    public double fee()
    {
        return FEE;
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
        fromId.debit(amount+fee());
        toId.credit(amount);
    }
}
