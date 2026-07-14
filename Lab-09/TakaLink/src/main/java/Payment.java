public class Payment extends Transaction{

    public Payment(Wallet payWallet,Wallet receiveWallet,double amount,String pin){
        super(payWallet, receiveWallet, amount, pin);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    public void settle() {

    }
}