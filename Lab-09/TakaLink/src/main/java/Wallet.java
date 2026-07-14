public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String  id, double balance, String pin){
        if(id==null ||id.isBlank()){
            throw new IllegalArgumentException("Wallet ID must not be blank");
        }
        if(pin ==null){
            throw new IllegalArgumentException("Wallet pin cannot be blank");
        }
        if(balance<=0){
            throw new IllegalArgumentException("Opening balance must be positive or must not be negative");

        }
        this.id=id;
        this.pin=pin;
        this.balance=balance;
        this.frozen=false;
        this.spentToday=0.0;

    }
    public final String getId(){
        return id;
    }
    public final boolean isFrozen(){
        return frozen;
    }
    public double balance(){
        return balance;
    }
    public boolean verifyPin(String p){
        return pin.equals(p);
    }
    public void freeze(){
        this.frozen=true;
    }
    public void unfreeze(){
        this.frozen=false;
    }
    protected abstract double dailyLimit();
    public double remainingDailyLimit(){
        return dailyLimit()-spentToday;
    }
    void debit(double amount) throws InsufficientBalanceException{
        if(amount<=0){
            throw new IllegalArgumentException("Debit amount must be positive");
        }
        if(balance-amount<0){
            throw new InsufficientBalanceException(id,amount,balance);
        }
        balance-=amount;
    }
    void credit(double amount){
        if(amount<=0) {
            throw new IllegalArgumentException("Credit amount must be positive");
        }
        balance+=amount;
    }
    void checkDailyLimit(double amount) throws DailyLimitExceededException {
        if(spentToday+amount>dailyLimit()){
            throw new DailyLimitExceededException(id,amount,remainingDailyLimit());
        }
    }
    void recordSpend(double amount){
        spentToday+=amount;
    }
    boolean canInitiateSend(){
        return true;
    }
    boolean canInitiateCashout(){
        return true;
    }
    boolean canInitiatePayment(){
        return true;
    }
    boolean canInitiateTopUp(){
        return true;
    }
}
