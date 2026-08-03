import java.lang.reflect.Type;

public abstract class Wallet {
    private String type;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String type, double balance, String pin){
        if(type.isBlank() || type == null){
            throw new IllegalArgumentException("Wallet type must be valid.");
        }
        if(pin.isBlank() || pin == null){
            throw new IllegalArgumentException("PIN can't be blank or null.");
        }
        if(balance < 0.0d){
            throw new IllegalArgumentException("Balance must be positive.");
        }
        this.type = type;
        this.balance = balance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0.0d;
    }

    public String getType(){
        return type;
    }
    public double balance(){
        return balance;
    }
    public boolean isFrozen(){
        return frozen;
    }
    public double getSpentToday(){
        return spentToday;
    }

    public void debit(double amount) throws IllegalArgumentException{
        if(amount <= 0.0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        if(balance()-amount < 0.0){
//            throw new InsufficientBalanceException("");
        }
        balance -= amount;
    }

    public void credit(double amount){
        if(amount <= 0.0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }

    public void freeze(){
        frozen = true;
    }

    public void checkFrozen() throws FrozenAccountException {
        if (frozen)
            throw new FrozenAccountException("Account frozen");
    }

    public abstract double getDailyLimit();
    public abstract boolean canSend();
    public abstract boolean canCashOut();
}
