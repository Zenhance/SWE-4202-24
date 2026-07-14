public abstract class Wallet {
    private final String name;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String name, double balance, String pin) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("name must not be null or blank");

        if (balance < 0) throw new IllegalArgumentException("Balance must not be negative");

        if (pin == null) throw new IllegalArgumentException("Pin must not be null");

        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }
    public String name() {
        return name;
    }

    public double balance() {
        return balance;
    }

    public boolean verifyPin(String candidate) {
        return pin.equals(candidate);
    }


    public void freeze() {
        frozen = true;
    }

    public void unfreeze() {
        frozen = false;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public double spentToday() {
        return spentToday;
    }

    void recordSpend(double amount) {
        spentToday += amount;
    }
    public abstract double dailyLimit();
    public abstract boolean canSend();
    public abstract boolean canCashOut();
    public abstract boolean isAgent();

    public void debit(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("debit amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    name + " has " + balance + " but needs to debit " + amount);
        }
        balance -= amount;
    }

    public void credit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("credit amount must be positive");
        }
        balance += amount;
        }
    }