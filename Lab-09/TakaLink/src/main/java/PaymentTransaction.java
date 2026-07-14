public class PaymentTransaction extends Transaction{
    public PaymentTransaction(Wallet from,Wallet to, double amount, String pin){
        super(from,to,amount,pin);
    }

    @Override
   public double getFee(){
        return 0;
    }
    @Override
    public String getType(){
      return "PAYMENT";

    }
    @Override
    protected void moveMoney()
        throws TransactionException{
        from.debit(amount);
        to.credit(amount);
    }
}
