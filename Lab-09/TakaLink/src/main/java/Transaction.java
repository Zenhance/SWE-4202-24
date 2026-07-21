// Transaction.java
public abstract class Transaction {
    // Legacy contractor public fields
    public String type;
    public double amount;
    public String fromId;
    public String toId;
    public String pin;

    // Direct wallet references initialized by the constructor
    final Wallet from;
    final Wallet to;

    public Transaction(String type, Wallet from, Wallet to, double amount, String pin) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive.");
        }
        if (from == null || to == null) {
            throw new IllegalArgumentException("Wallets cannot be null.");
        }
        if (pin == null) {
            throw new IllegalArgumentException("PIN cannot be null.");
        }

        this.type = type;
        this.amount = amount;

        // FIX: Using the id() method instead of the private id property field
        this.fromId = from.getId();
        this.toId = to.getId();

        this.pin = pin;
        this.from = from;
        this.to = to;
    }

    public double amount() {
        return this.amount;
    }

    public abstract double fee();

    abstract void executeMovement() throws InsufficientBalanceException;
    abstract void validateOperationSpecifics() throws OperationNotAllowedException;

    public final void settle() throws TransactionException {
        // 1. PIN Check
        if (!from.verifyPin(pin)) {
            throw new InvalidPinException("Incorrect PIN.");
        }

        // 2. Class specific rules (e.g. Merchant restrictions)
        validateOperationSpecifics();

        // 3. Daily limits check
        if (amount > (from.dailyLimit() - from.spentToday)) {
            throw new DailyLimitExceededException("Daily transaction limit exceeded.");
        }

        // 4. Total balance availability check
        double totalDebit = amount + fee();
        if (from.balance() - totalDebit < 0) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }

        // 5. Apply state changes atomically
        from.debit(totalDebit);
        executeMovement();
        from.spentToday += amount;
    }
}