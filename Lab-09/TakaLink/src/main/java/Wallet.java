public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id,double balance,String pin){
        if(id==null || id.isBlank()){
            throw new IllegalArgumentException("Invalid ID");
        }
        if(pin==null){
            throw new IllegalArgumentException("PIN cannot be null");
        }
        if(balance<0){
            throw new IllegalArgumentException("Negative balance");
        }
        this.id=id;
        this.balance = balance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0;
    }
    public String getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public boolean isFrozen(){
        return frozen;
    }
    public void freeze(){
        frozen=true;
    }
    public void unfreeze(){
        frozen=false;
    }
    public boolean verifyPin(String enteredPin){
        return pin.equals(enteredPin);
    }
    public void debit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Invalid debit");
        }
        if(balance<amount){
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance-=amount;
    }
    public void credit(double amount) {
        if(amount <= 0)
            throw new IllegalArgumentException("Invalid credit");
        balance += amount;
    }
}
