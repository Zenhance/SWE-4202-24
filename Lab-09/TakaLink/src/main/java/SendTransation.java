public class SendTransation extends Transaction{
    private static final double FEE=5.0;
    public SendTransation(Wallet from,Wallet to, Wallet amount, String pin){
        super(from,to,amount,pin);
    }
    @Override
    public double getFee(){
        return FEE;
    }





}
