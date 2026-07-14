public class SendTransation extends Transaction{
    private static final double FEE=5.0;
    public SendTransation(Wallet from,Wallet to, double amount, String pin){
        super(from,to,amount,pin);
    }
    @Override
    public double getFee(){
        return FEE;
    }
    @Override
    public String getType(){
        return "SEND";
    }
    @Override
    protected void moveMoney()
        throws TransactionException{
    from.debit(amount+getFee());
    to.credit(amount);
    }
}
