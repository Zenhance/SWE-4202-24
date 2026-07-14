package main.java;

public  abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id,double balance,String pin) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("You must provide your id");
        if(balance<0){
            throw new IllegalArgumentException("balance cannot be negative");
        }
        if(pin== null || pin.isBlank()){
            throw new IllegalArgumentException("pin cannot be null");
        }
        this.id=id;
        this.balance=balance;
        this.pin=pin;
        this.frozen=false;
        this.spentToday=0.0;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public double getSpentToday() {
        return spentToday;
    }
    public void debit(double amount) throws InsufficientBalanceException{
        if(amount<0){
            throw new IllegalArgumentException("amount cannot be negative");
        }
        if(amount>balance){
            throw new InsufficientBalanceException();
        }
        balance-=amount;
    }
    public void credit(double amount){
        if(amount<0){
            throw new IllegalArgumentException("amount cannot be negative");
        }
        balance+=amount;
    }
    public boolean verifyPin(String pin){
        return pin.equals(pin);
    }
    public void freeze(){
        frozen=true;
    }
    public void checkFrozen() throws FrozenAccountException{
        if(frozen){
            throw new FrozenAccountException();
        }
    }
}
