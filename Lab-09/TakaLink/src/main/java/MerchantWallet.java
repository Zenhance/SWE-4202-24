public class MerchantWallet extends Wallet{
    public MerchantWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }

    @Override
    public double dailyLimit(){
        return 0;
    }

    @Override
    public boolean allowedOperations(Operation operation){
        return operation!= Operation.SEND_MONEY && operation!= Operation.CASH_OUT;
    }
}
