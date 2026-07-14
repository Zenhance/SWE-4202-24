public class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id,double openingBalance,String pin){
        if(id==null || id.isBlank())
            throw new IllegalArgumentException("Wallet Id cannot be null or blank.");
        if(openingBalance<0)
            throw new IllegalArgumentException("Opening balance cannot be negative.");
        if(pin==null)
            throw new IllegalArgumentException("PIN cannot be null.");
        this.id=id;
        this.balance=openingBalance;
        this.pin=pin;
        this.frozen=false;
        this.spentToday=0;
    }
    //---------------------
    // Getters
    //---------------------
    public String getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public boolean isFrozen(){
    return frozen;
    }
    public double getSpentToday(){
    return spentToday;
    }
    public double getRemainingLimit(){
        return getDailyLimit()-spentToday;
    }
    //----------------
    // Wallet Operations
    //----------------
    public void verifypin(String enteredPin) throws WrongPinException{
        if(!pin.equals(enteredPin)) {
            throw new WrongPinException("Incorrect PIN.");
        }
    }
    public void checkFrozen() throws FrozenAccountException{
        if(frozen){
            throw new FrozenAccountException("Wallet is frozen.");
        }
    }
    public void freeze(){
        frozen=true;
    }
    public void unfreeze(){
        frozen=false;
    }
    public void debit(double amount)
        throws InsufficientBalanceException{
        if(amount<=0)
            throw new IllegalArgumentException("Debit amount must be positive.");
        if(balance<amount)
            throw new InsufficientBalanceException("Insufficient balance.");
        balance-=amount;
    }
    public void credit (double amount){
        if(amount<=0)
            throw new IllegalArgumentException("Credit amount must be positive.");
        balance+=amount;
    }
    public void recordSpend(double amount){
        spentToday+=amount;
    }
    //-------------------
    //Abstract methods
    //-------------------
    public abstract double getDailyLimit();
    public abstract void checkOperationAllowed(Transaction transaction)
        throws OperationNotAllowedException;
}


