public class SendMoney extends Transaction{
    private static final double FEE=5.0;

    public SendMoney(Wallet from,Wallet to,double amount,String pin){
        super(from,to,amount,pin);
    }

    public double fee(){
        return FEE;
    }

    protected void validate() throws TransactionException{
        if (!from.canSend())
            throw new OperationNotAllowedException();
        if(from.isFrozen())
            throw new FrozenAccountException();
        if(!from.verifyPin(pin))
            throw new InvalidPinException();
        if(from.getSpentToday() + amount > from.dailyLimit())
            throw new DailyLimitExceededException();
        if(from.balance()<amount+fee())
            throw new InsufficientBalanceException();
    }

    protected void transfer() throws TransactionException{
        from.debit(amount+fee());
        to.credit(amount);
    }
}
