public class MerchantWallet extends Wallet{
    public MerchantWallet(String id,double balance,String pin){
        super(id,balance,pin);
    }
    public double dailyLimit(){
        return 0.0;
    }

    public boolean canSendOut(){
        return false;
    }

    public boolean canCashOut(){
        return false;
    }
}


