public abstract class Wallet {

    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String id, double openingBalance, String pin) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("wallet id must not be null or blank");
        }
        if (pin == null) {
            throw new IllegalArgumentException("wallet PIN must not be null");
        }
        if (openingBalance < 0) {
            throw new IllegalArgumentException("opening balance must not be negative");
        }
        this.id = id;
        this.balance = openingBalance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0.0;
    }
    public final String id() {
        return id;
    }

    public final double balance() {
        return balance;
    }

    public final boolean isFrozen() {
        return frozen;
    }


    public final void freeze() {
        this.frozen = true;
    }

    public final void unfreeze() {
        this.frozen = false;
    }

    public final boolean verifyPin(String offeredPin) {
        return this.pin.equals(offeredPin);
    }

    public final void debit(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("debit amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(id, amount, balance);
        }
        balance -= amount;
    }
    public final void credit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("credit amount must be positive");
        }
        balance += amount;
    }


    final double remainingDailyLimit() {
        return dailyLimit() - spentToday;
    }


    final void recordSpend(double amount) {
        spentToday += amount;
    }

    protected abstract double dailyLimit();

    abstract boolean canBePayerOf(TransactionKind kind);

    abstract boolean canBeRecipientOf(TransactionKind kind);
}