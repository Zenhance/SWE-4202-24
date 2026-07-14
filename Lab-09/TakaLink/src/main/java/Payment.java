public class Payment extends Transaction{
    public Payment(Wallet from,Wallet to,double amount,String pin){
        super(from,to,amount,pin);
    }

    public double fee(){
        return 0.0;
    }

    protected void validate()throws TransactionException{
        if(!(to instanceof MerchantWallet))
            throw new OperationNotAllowedException();
        if(!from.canSend())
            throw new OperationNotAllowedException();
        if(from.isFrozen())
            throw new FrozenAccountException();
        if(!from.verifyPin(pin))
            throw new InvalidPinException();
        if(from.balance()<amount)
            throw new InsufficientBalanceException();
    }

    protected void transfer()throws TransactionException{
        from.debit(amount);
        to.credit(amount);
    }
}
