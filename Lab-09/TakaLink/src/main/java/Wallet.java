public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id,double balance,String pin){
        if(id==null){
            throw new IllegalArgumentException("Invalid ID");
        }
        if(balance<0){
            throw new IllegalArgumentException("Invalid Balance");
        }
        if(pin==null){
            throw new IllegalArgumentException("Invalid PIN");
        }
        this.id=id;
        this.balance=balance;
        this.pin=pin;
        this.frozen=false;
        this.spentToday=0;
    }

    public double balance(){
        return balance;
    }

    public void debit(double amount) throws InsufficientBalanceException{
        if(amount<=0){
            throw new IllegalArgumentException("Invalid Amount");
        }
        if(balance<amount){
            throw new InsufficientBalanceException();
        }
        balance-=amount;
    }

    public void credit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Invalid Amount");
        }
        balance+=amount;
    }

    public boolean verifyPin(String enteredPin){
        return pin.equals(enteredPin);
    }

    public void freeze(){
        frozen=true;
    }

    public boolean isFrozen(){
        return frozen;
    }

    public double getSpentToday(){
        return spentToday;
    }

    public void addSpent(double amount){
        spentToday+=amount;
    }

    public double remainingLimit(){
        return dailyLimit()-spentToday;
    }

    public String getId(){
        return id;
    }

    public abstract double dailyLimit();
    public abstract boolean canSend();
    public abstract boolean canCashOut();
}
