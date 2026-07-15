public class Payment extends Transaction
{
    public Payment(Wallet fromId, Wallet toId, double amount, String pin)
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
        if(!(toId instanceof MerchantWallet))
            throw new OperationNotAllowedException();
    }

    @Override
    public void moveMoney() throws TransactionException
    {
        fromId.debit(amount());
        toId.credit(amount());
    }
}
