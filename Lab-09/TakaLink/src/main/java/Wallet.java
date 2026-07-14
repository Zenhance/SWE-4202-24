public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id, double balance,String pin ,boolean frozen){
        if(id== null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id");
        }
        if(balance<0.0){
            throw new IllegalArgumentException("Invalid balance");
        }
        if(pin==null){
            throw new IllegalArgumentException("Invalid pin");
        }
        this.id=id;
        this.balance=balance;
        this.pin =pin;
        this.frozen=frozen;
        this.spentToday=0;
    }
    public String getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public  String getPin(){
        return pin;
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    public double getSpentToday() {
        return this.spentToday;
    }

    public void debit(double amount)throws InsufficientBalanceException{
        if(amount<=0){
            throw new IllegalArgumentException("Invalid Amount");

        }
        if(balance<amount){
            throw new InsufficientBalanceException("Invalid amount");
        }
        balance-=amount;
    }
    public void credit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance+=amount;
    }
    public void addSpent(double amount){
        spentToday+=amount;
    }
    public boolean verifyPin(String enteredPin){
        return pin.equals(enteredPin);
    }
    public void freeze(){
        frozen=true;
    }
    public abstract double dailyLimit();
    public abstract boolean canSend();
    public abstract boolean canCashOut();


}

