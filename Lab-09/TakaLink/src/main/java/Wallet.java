public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String id, double balance, String pin) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Invalid id");
        if (pin == null || pin.isBlank()) throw new IllegalArgumentException("Invalid pin");
        if (balance < 0) throw new IllegalArgumentException("Negative balance");
        this.id = id;
        this.balance = balance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0.0;
    }

    public String id() { return id; }

    public double balance() { return balance; }

    public boolean isFrozen() { return frozen; }

    public void freeze() { this.frozen = true; }

    public boolean verifyPin(String offered) {
        if (offered == null) return false;
        return this.pin.equals(offered);
    }

    public void debit(double amount) throws InsufficientBalanceException{
        if(amount <= 0) throw new IllegalArgumentException("Debit ammount must be positive");
        if(balance-amount < 0) throw new InsufficientBalanceException(id);
        balance -= amount;
    }

    public void credit(double amount){
        if(amount <=0) throw new IllegalArgumentException("Credit must be positive");
        balance +=amount;
    }

    public double spentToday(){
        return spentToday;
    }

    protected void addSpentToday(double amount){
        this.spentToday += amount;
    }

    public double remainingLimit(){
        return dailyLimit() - spentToday;
    }

    public boolean canSpendAmount(double amount){
        return (spentToday + amount) <= dailyLimit();
    }

    protected abstract double dailyLimit();
    protected abstract boolean maySend();
    public abstract boolean mayCashOut();


}
