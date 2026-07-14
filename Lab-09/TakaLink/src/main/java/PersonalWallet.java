public class PersonalWallet extends Wallet {
    public static final double DailyLimit=25000.00;
    public PersonalWallet(String id , double balance , String pin){
        super(id,balance,pin);
    }

    @Override
    public double dailyLimit() {
        return DailyLimit;
    }

    @Override
    public boolean canSend() {
        return true;
    }

    @Override
    public boolean canCashOut() {
        return true;
    }




}
