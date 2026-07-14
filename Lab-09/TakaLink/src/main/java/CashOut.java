public class CashOut extends Transaction{

public CashOut (Wallet fromId, Wallet toId, double amount, String pin)
{


    super(fromId, toId, amount, pin);
}
    @Override
    public double fee()
    {
        return getAmount()*0.0185;
    }
    @Override
    public void validateOperation() throws OperationNotAllowedException
    {
        if(!fromId.canSendMoney())
            throw new OperationNotAllowedException();
        if(!(toId instanceof AgentWallet))
            throw new OperationNotAllowedException();
    }
    @Override
    public void moveMoney() throws TransactionException
    {
        fromId.debit(amount+fee());
        toId.credit(amount);
    }
}
