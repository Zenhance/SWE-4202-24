public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id, double balance, String pin) {
        if (id == null || id.isBlank() || balance < 0 || pin == null) {
            throw new IllegalArgumentException("Invalid Inputs");
        }
        this.id = id;
        this.pin = pin;
        this.balance = balance;
        this.frozen = false;
        this.spentToday = 0.0;
    }

    public double balance() {
        return this.balance;
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    public void freeze() {
        this.frozen = true;
    }

    public boolean verifyPin(String pinEntered) {
        return this.pin.equals(pinEntered);
    }

    public double spentToday() {
        return this.spentToday;
    }

    public abstract double dailyLimit();

    public void debit(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (this.balance - amount < 0) {
            throw new InsufficientBalanceException("Not enough funds");
        }

        this.balance -= amount;
    }

    public void credit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        this.balance += amount;
    }


}