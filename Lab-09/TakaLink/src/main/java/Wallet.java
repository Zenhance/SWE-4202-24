public abstract class Wallet {

    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String id, double openingBalance, String pin)
    {
        if (id== null || id.isBlank()) {
            throw new IllegalArgumentException("Wallet ID cannot be null or blank");
        }
        if (openingBalance< 0.0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        if (pin== null) {
            throw new IllegalArgumentException("PIN cannot be null");
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
    public final void debit(double amount)
            throws InsufficientBalanceException {
        if (amount<= 0.0) {
            throw new IllegalArgumentException(
                    "Debit amount must be positive"
            );
        }
        if (balance< amount) {
            throw new InsufficientBalanceException("Insufficient balance in wallet " + id);
        }
        balance -= amount;
    }
    public final void credit(double amount) {
        if (amount<= 0.0) {
            throw new IllegalArgumentException("Credit amount must be positive");
        }
        balance += amount;
    }
    public final boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public final boolean isFrozen() {
        return frozen;
    }
    public final void freeze() {
        frozen = true;
    }
    public final double remainingDailyLimit() {
        return Math.max(
                0.0,
                dailyLimit() - spentToday
        );
    }

    final void recordSpend(double amount) {
        spentToday += amount;
    }

    protected abstract double dailyLimit();
    public abstract boolean canSendMoney();
    public abstract boolean canCashOut();
    public abstract boolean canMakePayment();
    public abstract boolean canTopUp();
    public boolean canReceiveCashOut() {
        return false;
    }
    public boolean canReceivePayment() {
        return false;
    }


}