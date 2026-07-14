public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean  frozen;
    private double spentToday;

    protected Wallet(String id, double openingBalance, String pin){
        if(id==null || id.isBlank()){
            throw new IllegalArgumentException("wallet id must not be null/Blank");
        }
        if(pin==null){
            throw new IllegalArgumentException("PIN must not be null");
        }
        if(openingBalance<0){
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.id=id;
        this.balance=openingBalance;
        this.pin=pin;
        this.frozen=false;
        this.spentToday=0.0;
    }
    public String getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }

    public boolean isFrozen() {
        return frozen;
    }
    public void setFrozen(){
        this.frozen=true;
    }
    public void unfreeze(){
        this.frozen=false;
    }
    public boolean verifyPin(String candidate){
        return pin.equals(candidate);
    }
    public double remainingDailyLimit(){
        return getDailyLimit() - spentToday;
    }
    void debit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Debit amoount must be positive");
        }
        if(balance-amount<0){
            throw new IllegalArgumentException("");
        }
    }
}
