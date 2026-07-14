public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;
    protected Wallet(String id, double balance, String pin){
        if(id==null || id.isBlank()){
            throw new IllegalArgumentException("The Id can't be blank.");
        }
        if(balance <0){
            throw new IllegalArgumentException("The initial deposit can't be negative");
        }
        if(pin==null || pin.isBlank()){
            throw new IllegalArgumentException(("The pin can't be emplty"));
        }
        this.id=id;
        this.balance=balance;
        this.pin=pin;
    }
    public double getBalance(){return balance;}
    public void debit(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (balance - amount < 0) {
            throw new InsufficientBalanceException(id + " has insufficient balance for " + amount);
        }
        balance -= amount;
    }

    public void credit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }
    public boolean verifyPin(String offeredPin) {
        return pin.equals(offeredPin);
    }
    public boolean isFrozen(){
        return frozen;
    }
    public void freeze(){
        frozen=true;
    }
    public void unfreeze() {
        frozen = false;
    }
    public double remainingDailyLimit() {
        return dailyLimit() - spentToday;
    }
    public abstract double dailyLimit();
}