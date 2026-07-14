public class PersonalWallet extends Wallet{
    private String type;
    private String pin;
    private double balance;
    private final double dailySendingLimit = 25000;

    public PersonalWallet(String type, String pin, double balance, boolean frozen, double spentToday) {
        super(frozen, spentToday);
        this.type = type;
        this.pin = pin;
        this.balance = balance;
    }

    @Override
    public double cashOut(double amount){
        balance = balance - amount;
        return balance;
    }

    @Override
    public double sendMoney(double amount){
        balance = balance - amount;
        return balance;
    }

    @Override
    public double receiveMoney(double amount){
        balance = balance + amount;
        return balance;
    }
}
