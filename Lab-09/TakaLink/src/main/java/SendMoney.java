public class SendMoney extends Transaction {
    private static final double FlAT_FEE =5.0;
    public SendMoney(Wallet from, Wallet to, double amount, String offeredPin){
        super(from, to, amount, offeredPin);
    }

    @Override
    public double fee(){
        return FlAT_FEE;
    }

    @Override
    protected boolean operationAllowed() {
        return from.maySend();
    }

    @Override
    protected void performTransfer(double totalDebit) throws TransactionException{

        try{
            from.debit(totalDebit);
            to.credit(amount);
            from.addSpentToday(amount);
        }

        catch (InsufficientBalanceException e){
            throw e;
        }
    }
}
