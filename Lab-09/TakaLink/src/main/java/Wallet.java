public abstract class Wallet {
    private String id;
   private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String id,double balance,String pin,boolean frozen,double spentToday){
        if (id==null||id.isBlank())
            throw new IllegalArgumentException("Wallet must have ID");
        if (balance<0)
            throw new IllegalArgumentException("Balance cannot be negative");
        if (pin==null)
            throw new IllegalArgumentException("Pin has to be entered");
        this.balance=balance;
        this.id=id;
        this.pin=pin;
        this.frozen=frozen;
        this.spentToday=spentToday;
    }
    protected Wallet(String id, double balance, String pin) {
        this(id, balance, pin, false,0);
    }
    public double balance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public void debit(double v) {
        if (v<0)
            throw new IllegalArgumentException("Amount cannot be negative");
        if (balance-v<0)
            throw new IllegalArgumentException("Amount cannot be greater than balance");
        balance-=v;

    }

    public void credit(double v) {
        if (v<0)
            throw new IllegalArgumentException("Amount cannot be negative");
        balance+=v;
    }

    public boolean verifyPin(String number) {
        return this.pin.equals(number);
    }

    public void freeze() {
        this.frozen=true;
    }

    public boolean isFrozen() {
        return frozen;
    }

    protected abstract double getDailylimit();
    protected abstract boolean canPay(TransactionType type);

    public void recordSpend(double amount) {
        spentToday+=amount;
    }

    public double getBalance() {
        return balance;
    }

    public double remainingDailyLimit() {
        return getDailylimit()-spentToday;
    }
}
