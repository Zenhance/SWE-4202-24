public class PersonalWallet extends Wallet{
    private String type;
    private String pin;
    private double balance;

    public PersonalWallet(String type, String pin, double balance){
        super(type, pin, balance);
    }

    public double cashOut(double amount){
        balance = balance - amount;
        return balance;
    }

    public double sendMoney(double amount){
        balance = balance - amount;
        return balance;
    }

    public double receiveMoney(double amount){
        balance = balance + amount;
        return balance;
    }
}
