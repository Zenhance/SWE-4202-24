public class Payment extends Transaction{
    public Payment (Wallet from, Wallet to, double amount, String pin){
        super(from,to,amount,pin);
    }

    public double fee(){
        return 0.0;
    }

    protected boolean isPayerAllowed(){
        return true;
    }
}
