public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id, double balance, String pin) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException();

        if (balance < 0) throw new IllegalArgumentException();

        if (pin == null) throw new IllegalArgumentException();
        this.id = id;
        this.balance = balance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0;
    }

    public double balance() {
        return balance;
    }

    public void debit(double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new IllegalArgumentException();
        if (balance < amount) throw new InsufficientBalanceException();
        balance -= amount;
    }

    public void credit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        balance += amount;
    }

    public boolean verifyPin(String pin) {
        return this.pin.equals(pin);
    }

    public void freeze() {
        this.frozen = true;
    }
    public boolean isFrozen() {
        return frozen;
    }

    public abstract double dailyLimit();

    public double spentToday() {
        return spentToday;
    }
    public void addToSpentToday(double amount) {
        spentToday += amount;
    }
}
