public class PersonalWallet extends Wallet{
    private final double DAILY_LIMIT=25000.0;
    public PersonalWallet(String id, double balance, String pin){
        super(id,balance,pin);
    }
    @Override
    public double dailyLimit(){
        return DAILY_LIMIT;
    }

}
