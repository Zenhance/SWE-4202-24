public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String  id, double balance, String pin){
        if(id==null ||id.isBlank()){
            throw new IllegalArgumentException("Wallet ID must not be blank");
        }
        if(pin ==null){
            throw new IllegalArgumentException("Wallet pin cannot be blank");
        }
        if(balance<0){
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
    public double getBalance(){
        return balance;
    }
}
