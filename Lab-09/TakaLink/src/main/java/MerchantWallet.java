public class MerchantWallet extends Wallet{

    double limit = Double.MAX_VALUE;

    public MerchantWallet(String name, double deposit, String pin){
        super(name, deposit, pin);
    }


}
