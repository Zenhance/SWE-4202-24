public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String id, double openingBalance, String pin) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Invalid wallet id");
        }

        if (openingBalance < 0) {
            throw new IllegalArgumentException(
                    "Opening balance cannot be negative"
            );
        }
        if (pin == null) {
            throw new IllegalArgumentException("PIN cannot be null");
        }

        this.id = id;
        this.balance = openingBalance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double amount)
            throws InsufficientBalanceException {
        if (amount < 0) throw new IllegalArgumentException("Amount must be positive");
        if (balance - amount < 0) {
            throw new InsufficientBalanceException();
        }

        balance -= amount;
    }

    public void credit(double amount)
            throws InsufficientBalanceException {
        if (amount < 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
    }

    public boolean verifyPin(String offeredPin) {
        return pin.equals(offeredPin);
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void freeze() {
        frozen = true;
    }

    public abstract double dailyLimit();

    public abstract boolean allows(TransactionType type);

}

