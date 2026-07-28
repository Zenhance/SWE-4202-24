package src.main.java;

public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id, double balance, String pin){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid Id");
        }
        if(balance<0){
            throw new IllegalArgumentException("Balance cant be zero");
        }
        if(pin == null){
            throw new IllegalArgumentException("Provide valid PIN");
        }
        this.id = id;
        this.balance = balance;
        this.pin = pin;
        this.frozen = false;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
    public abstract double getDailyLimit();

    public void debit(double amount)  throws InsufficientBalanceException{
        if(amount<=0){
            throw new IllegalArgumentException("Enter valid amount");
        }
        if(amount>balance){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance = balance - amount;

    }
    public void credit(double amount){
        if(amount <=0){
            throw new IllegalArgumentException("Invalid amount");
        }
        balance = balance+amount;
    }
    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public void checkFrozen() throws FrozenAccountException{
        if(frozen){
            throw new FrozenAccountException("Your account has been frozen");
        }
    }
    public void addSpent(double amount){
        spentToday += amount;
    }
    public double getRemainingDailyLimit(){
        return getDailyLimit() - spentToday;
    }
    public abstract void validateOperation(Transaction transaction) throws OperationNotAllowedException;

}
