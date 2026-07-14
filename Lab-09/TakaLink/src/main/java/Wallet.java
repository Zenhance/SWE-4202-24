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
    public void verifyPin(String enteredPin)
        throws WrongPinException{
        if(!pin.equals(enteredPin))
            throw new WrongPinException();
    }
    public void checkFrozen()
        throws FrozenAccountException{
        if(frozen)
            throw new FrozenAccountException();

    }
    public void debit(double amount)

        throws InsufficientBalanceException{
        if(amount<=0)
            throw new IllegalArgumentException("Invalid amount");
        if(balance<amount)
            throw new InsufficientBalanceException();
        balance-=amount;
    }
    public void credit(double amount){
        if(amount<=0)
            throw new IllegalArgumentException("Invalid amount");
        balance+=amount;
    }
    public void addSpent(double amount){
        spentToday+=amount;
    }
















}
