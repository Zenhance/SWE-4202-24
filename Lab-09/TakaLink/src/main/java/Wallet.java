public abstract class Wallet {
    private final String id;
    private final double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id,double initialBalance,String pin){
        this.id=id;
        this.balance=initialBalance;
        this.pin=pin;
        this.frozen=false;
    }
    public double getBalance(){
        return this.balance;
    }

    public boolean isFrozen() {
        return this.frozen;
    }
    public boolean verifyPin(){
        return this.pin.equals(pin);
    }
    public void freeze(){
        this.frozen=true;
    }
    public double SpentToday(){

    }
}
