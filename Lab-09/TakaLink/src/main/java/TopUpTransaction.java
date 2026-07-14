public class TopUpTransaction extends Transaction{
    public TopUpTransaction(Wallet from, Wallet to, double amount,String pin){
        super(from,to,amount,pin);
    }
    @Override
    public double getFee(){
        return 0;

    }
    @Override
    public String getType(){
        return "TOPUP";
    }
    @Override
    protected void moveMoney()
        throws TransactionException{
        from.debit(amount);
        to.credit(amount);
    }
}
