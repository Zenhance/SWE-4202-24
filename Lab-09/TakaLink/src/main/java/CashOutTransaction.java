public class CashOutTransaction extends Transaction{
    private static final double RATE=0.01123;
    public CashOutTransaction(Wallet from,Wallet to, double amount,String pin){
        super(from,to,amount,pin);

    }
    @Override
    public double getFee(){
        return amount*RATE;
    }

}
