import java.security.PublicKey;

public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id, double balance,String pin){
        if(id==null || id.isBlank())
            throw new IllegalArgumentException("Invalid wallet ID");
        if(balance<0)
            throw new IllegalArgumentException("Balance cant be negative");
        if(pin == null)
            throw new IllegalArgumentException("PIN cant be null");

        this.id=id;
        this.balance;
        this.pin=pin;
        this.frozen= false;
        this.spentToday=0;
    }















}
