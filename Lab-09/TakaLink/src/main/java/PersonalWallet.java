public class PersonalWallet extends Wallet{
    private static final double DAILY_LIMIT=25000;
    public PersonalWallet(String id, double balance, String pin){
        super(id,balance,pin);
    }
}
