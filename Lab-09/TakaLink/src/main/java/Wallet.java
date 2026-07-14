import javax.naming.InsufficientResourcesException;

public abstract class Wallet {
    private String id;
    private String pin;
    private double balance;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id,double balance, String pin){
        if(id==null || id.isBlank()){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(balance<0){
            throw new IllegalArgumentException("Balance must be positive");
        }
        if(pin==null || pin.isBlank()){
            throw new IllegalArgumentException("Pin cannot be null");
        }
        this.id=id;
        this.balance=balance;
        this.pin=pin;
    }

    public boolean verifyPin(String typedPin){
        return pin.equals(typedPin);
    }

    public String getId(){
        return id;
    }

    public double balance(){
        return balance;
    }

    public double getSpentToday(){
        return spentToday;
    }

    public void freeze(){
        frozen=true;
    }

    public boolean isFrozen(){
        return frozen;
    }

    public void debit(double amount) throws InsufficientBalanceException {
        if(amount<=0){
            throw new IllegalArgumentException("amount must be positive");
        }
        if((balance-amount)<0){
            InsufficientBalanceException(id + "has insufficient balance for a debit of" + amount);
        }
        balance-=amount;
    }

    public void credit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("amount must be positive");
        }
        balance+=amount;
    }

    public void addSpent(double amount){
        spentToday=spentToday+amount;
    }

    public double remainingLimit(){
        return dailyLimit()-spentToday;
    }

    public abstract double dailyLimit();
    public abstract boolean canSendMoney();
    public abstract boolean canCashOut();
    public abstract boolean canTopUp();
    public abstract boolean canPayment();

}
