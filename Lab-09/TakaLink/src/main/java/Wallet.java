package src.main.java;

public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id,double balance,String pin){
        if(id==null || id.isBlank()){
            throw new IllegalArgumentException("Wallet id can't be null");
        }
        if(balance<0){
            throw new IllegalArgumentException("balance can not be negative");
        }
        if(pin== null || pin.isBlank()){
            throw new IllegalArgumentException("pin can't be null");
        }
        this.id=id;
        this.balance=balance;
        this.pin=pin;
        this.frozen=false;
        this.spentToday=0.0;
    }

    public String Id() {
        return id;
    }

    public double Balance() {
        return balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public double spentToday() {
        return spentToday;
    }
    public String pin(){
        return pin;
    }
    public abstract double getDailyLimit();
    public abstract boolean canSend();
    public abstract boolean canCashOut();
    public void debit(double amount){
        if(amount>balance){
        throw new IllegalArgumentException("Insufficient Balance");
        }
        else if(amount<0){
            throw new IllegalArgumentException("Amount can not be negative");
        }
        balance-=amount;
    }
    public void Credit(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Amount can not be negative");
        }
        balance+=amount;
    }
    public boolean verifyPin(String pin){
        return pin().equals(pin);
    }
    public void freeze(){
        frozen=true;
    }
    public void checkFrozen() throws FrozenAccountException{
        if(frozen)
            throw new FrozenAccountException();
    }
    public double remainingLimit(){
        return getDailyLimit()-spentToday();
    }
    public void addSpent(double amount){
        spentToday+=amount;
    }
    }


