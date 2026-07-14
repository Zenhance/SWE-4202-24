public class Wallet
{
    private String id;
    private double amount;
    private String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id, double amount, String pin)
    {
        if(id==null || id.isBlank())
            throw new IllegalArgumentException("Id can not be null");
        if(amount<=0)
            throw new IllegalArgumentException("Amount must be positive");
        if(pin==null || pin.isBlank())
            throw new IllegalArgumentException("Pin can not be null");
        this.id = id;
        this.amount = amount;
        this.pin = pin;
        this.frozen=false;
        this.spentToday=0;
    }

    public boolean verifyPin(String typedPin)
    {
        return pin.equals(typedPin);
    }

    public String getId()
    {
        return id;
    }

    public double getAmount()
    {
        return amount;
    }

    public void freeze()
    {
        frozen=true;
    }

    public boolean isFrozen()
    {
        return frozen;
    }
}
