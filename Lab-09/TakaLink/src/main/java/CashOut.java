
public class CashOut extends Transaction {
    private static final double RATE = 0.0185;

    public CashOut(Wallet from, Wallet to,double amount, String offeredPin){
        super(from, to, amount, offeredPin);
    }

    @Override
    public double fee(){
        return amount*RATE;
    }

    @Override
    protected boolean operationAllowed(){
        return from.mayCashOut() && (to instanceof AgentWallet);
    }
    @Override
    protected void performTransfer(double totalDebit) throws TransactionException{
        try{
            from.debit(totalDebit);
            to.credit(amount + fee());
            from.addSpentToday(amount);
        }

        catch(InsufficientBalanceException e){
            throw e;
        }
    }


}
