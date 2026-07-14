public class TopUpTransaction extends Transaction{
    public TopUpTransaction(Wallet from, Wallet to, double amount,String pin){
        super(from,to,amount,pin);
    }
    @Override
    public double getFee(){
        return 0;

    }
}
