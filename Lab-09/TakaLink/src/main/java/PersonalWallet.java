public class PersonalWallet extends Wallet{
    private static final double DAILY_LIMIT=25000.0;
    public PersonalWallet(String id, double balance,String pin){
        super(id,balance,pin);
    }


    public double dailyLimit(){
        return DAILY_LIMIT;
    }

    public boolean canSendOut(){
        return true;
    }

    public boolean canCashOut(){
        return true;
    }
}
