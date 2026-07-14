public class PersonalWallet extends Wallet{
    private static final double DAILY_LIMIT=50000.0;

    public PersonalWallet(String id,double balance,String pin){
        super(id,balance,pin);
    }
    @Override
    protected  double dailyLimit(){
        return DAILY_LIMIT;
    }
}
