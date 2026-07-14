public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private double spentToday;
    private boolean frozen;

    protected Wallet(String id, double balance, String pin) {
        if(id==null) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        if(balance<0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if(pin==null) {
            throw new IllegalArgumentException("PIN cannot be empty");
        }

        this.id=id;
        this.balance=balance;
        this.pin=pin;
        this.frozen=false;
        this.spentToday=0.0;
    }

    public String id(){
        return id;
    }

    public double balance(){
        return balance;
    }

    public void debit(double amount) throws InsufficientBalanceException {
        if(amount<=0) {
            throw new InsufficientBalanceException ("Debit amount cannot be negative");
        }
        balance -=amount;
    }

    public void credit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException ("Credit amount cannot be negative");
        }
        balance+=amount;
    }

    public boolean verifyPin(String candidate){
        return pin.equals(candidate);
    }

    public boolean isFrozen(){
        return frozen;
    }

    public void freeze(){
        frozen=true;
    }

    public abstract double dailyLimit();

    public double remainingDailyLimit(){
        return 0.0;
    }

    void recordSpend(double amount){

    }

    public boolean canSend(){
        return true;
    }

    public boolean canInitiateCashOut(){
        return true;
    }

    public boolean canReceiveCashOut(){
        return false;
    }
}
