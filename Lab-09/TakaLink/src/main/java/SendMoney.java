public class SendMoney extends Transaction{
    private static final double FLAT_FEE=5.0;

    public SendMoney(Wallet from,Wallet to,  double amount, String pin){
        super(from,to,amount,pin);
    }

    public double fee(){
        return FLAT_FEE;
    }

    protected boolean isPayerAllowed(){
        return from.canSend();
    }
}
