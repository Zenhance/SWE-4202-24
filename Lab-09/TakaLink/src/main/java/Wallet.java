package src.main.java;

public abstract class Wallet {
    private String name;
    private double balance;
    private String pin;
    private boolean frozenStatus;
    private double sentToday;

    public Wallet(String name,double balance, String pin){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if(balance<0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        if(pin==null || pin.isBlank()){
            throw new IllegalArgumentException("Pin cannot be empty");
        }
        this.name=name;
        this.balance=balance;
        this.pin=pin;
        this.frozenStatus=false;
        this.sentToday=0.0;
    }

    public double balance(){
        return this.balance;
    }

    public void debit(double amount){
        if(amount<0.0){
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        if(amount>balance){
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance-=balance;
    }

    public void credit(double amount){
        if(amount<0.0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance+=balance;
    }

    public boolean verifyPin(String pin){
        return this.pin.equals(pin);
    }

    public void freeze(){
        this.frozenStatus=true;
    }

}
