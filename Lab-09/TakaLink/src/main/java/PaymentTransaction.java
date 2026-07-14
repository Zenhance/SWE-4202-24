public class PaymentTransaction extends Transaction{
    public PaymentTransaction(Wallet from,Wallet to, double amount, String pin){
        super(from,to,amount,pin);
    }

    @Override
   public double getFee(){
        return 0;
    }
}
