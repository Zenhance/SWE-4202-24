package src.main.java;

public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id,double balance,String pin,boolean frozen,double spentToday){
        if(id==null || id.isBlank()){
            throw new IllegalArgumentException("Wallet id can't be null");
        }
        if(balance<0){
            throw new IllegalArgumentException("balance can not be negative");
        }
        if(pin== null || pin.isBlank()){
            throw new IllegalArgumentException("pin can't be null"):
        }
        this.id=id;
        this.balance=balance;
        this.pin=pin;
        this.frozen=false;
        this.spentToday=0.0;
    }
}
