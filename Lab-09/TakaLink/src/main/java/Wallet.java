public abstract class Wallet {
    private final String id;
    private final String pin;
    private double balance;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id, double balance, String pin) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException();
        if (pin == null || pin.isEmpty()) throw new IllegalArgumentException();
        if (!Double.isFinite(balance) || balance < 0) throw new IllegalArgumentException();

        this.id = id;
        this.pin = pin;
        this.balance = balance;
        this.frozen = false;
        this.spentToday = 0.0;
    }

    public String getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

    public double balance() {
        return balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void freeze() {
        frozen = true;
    }

    public double getSpentToday() {
        return spentToday;
    }

    public void debit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(" amount must be positive , got " + amount);
        }
        if (amount > balance) {
            throw new IllegalStateException(" balance " + balance + " too low for " + amount);
        }
        balance -= amount;
    }

    public void credit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(" amount must be positive");
        }
        balance += amount;
    }

    public boolean verifyPin(String pin) {
        return this.pin.equals(pin);
    }

    public void setSpentToday(double spentToday) {
        if (spentToday <= 0) {
            throw new IllegalArgumentException(" spent today must be positive");
        }
        this.spentToday += spentToday;
    }

    public double remainingDailyLimit(){
        return Math.max(0,dailyLimit()-spentToday);
    }

    public abstract double dailyLimit();
    public abstract boolean allowedOperations(Operation operation);
}