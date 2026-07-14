public abstract class Wallet {
    private final String id;
    private  double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id,double initialBalance,String pin){
        this.id=id;
        this.balance=initialBalance;
        this.pin=pin;
        this.frozen=false;
    }
    public double getBalance(){
        return this.balance;
    }

    public boolean isFrozen() {
        return this.frozen;
    }
    public boolean verifyPin(){
        return this.pin.equals(pin);
    }
    public void freeze(){
        this.frozen=true;
    }
    public double SpentToday(){
     return   this.spentToday;
    }
    public void debit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Debit must be positive");
        }
        this.balance -= amount;
    }
    public void credit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Credit must be positive");
        }
        this.balance += amount;
    }
public abstract double getDailyLimit();
}
