public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id, double balance, String pin) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Wallet can not be null");
        if (balance < 0) throw new IllegalArgumentException("Balance can not be negative");
        if (pin == null || pin.isBlank()) throw new IllegalArgumentException("Pin can not be null");

        this.id = id;
        this.balance = balance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0.0;
    }

    public String id() {
        return id;
    }

    public double balance() {
        return balance;
    }

    public String pin() {
        return pin;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public double spentToday() {
        return spentToday;
    }

    public abstract double getDailyLimit();
    public abstract boolean canSend();
    public abstract boolean canCashOut();

    public  void debit(double amount) throws InsufficientBalanceException {
        if (amount < 0)
            throw new IllegalArgumentException("Amount can not be negative");
        if (amount > getBalance()) throw new InsufficientBalanceException();
        balance -= amount;
    }

    public void credit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount can not be negative");
        balance += amount;
    }
    public boolean verifyPin(String pin) {
        return getPin().equals(pin);
    }

    public void freeze() {
        frozen = true;
    }

    public void checkFrozen() throws FrozenAccountException {
        if (frozen)
            throw new FrozenAccountException();
    }

    public double remainingLimit() {
        return getDailyLimit() - getSpentToday();
    }
    public void addSpent(double amount){
        spentToday+=amount;
    }

}
