public class PersonalWallet extends Wallet{
    private String type;
    private String pin;
    private double balance;
    private final double dailySendingLimit = 25000;

    public PersonalWallet(String type, String pin, double balance, boolean frozen, double spentToday) {
        super(type, pin, balance);
    }

    @Override
    public boolean cashOut(){
        return true;
    }

    @Override
    public boolean sendMoney(){
        return true;
    }

    @Override
    public boolean receiveMoney(){
        return true;
    }
}
