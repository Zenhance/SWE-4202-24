public class Payment extends Transaction {
    public Payment(Wallet from, Wallet to, double amount, String offeredPin){
        super(from, to, amount, offeredPin);
    }

    @Override
    public double fee(){
        return 0.0;
    }

    @Override
    protected boolean operationAllowed(){
        return true;
    }

    @Override
    protected void performTransfer(double totalDebit) throws TransactionException{
        try {
            from.debit(totalDebit);
            to.credit(amount);
            from.addSpentToday(amount);
        }
        catch (InsufficientBalanceException e){
            throw e;
        }
    }
}
