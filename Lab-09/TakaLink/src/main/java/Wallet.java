public  abstract class Wallet
{
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id, double balance, String pin)
    {
        if(id==null || id.isBlank())
            throw new IllegalArgumentException("Id can not be null");
        if(balance<=0)
            throw new IllegalArgumentException("Amount must be positive");
        if(pin==null || pin.isBlank())
            throw new IllegalArgumentException("Pin can not be null");
        this.id = id;
        this.balance = balance;
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

    public double getBalance()
    {
        return balance;
    }

    public double getSpentToday()
    {
        return spentToday;
    }

    public void freeze()
    {
        frozen=true;
    }

    public boolean isFrozen()
    {
        return frozen;
    }

   public void debit(double amount) throws InsufficientBalanceException
   {
       if(amount<=0)
           throw new IllegalArgumentException("Amount must be positive");
       if(balance-amount<=0)
           throw new InsufficientBalanceException();
       balance=balance-amount;
   }

   public void credit(double amount)
   {
       if(amount<=0)
           throw new IllegalArgumentException("Amount must be positive");
       balance=balance+amount;
   }

   public double remainingLimit()
   {
       return dailyLimit()-spentToday;
   }

    public abstract boolean canSendMoney();

    public abstract boolean canCashOut();

    public abstract boolean canTopUp();

    public abstract boolean canPayment();

    public abstract double dailyLimit();
}