public abstract class Wallet {
    private String name;
    private double balance;
    private String PIN;
    private boolean frozenStatus;
    private double sentToday;

    public Wallet(String name, double balance, String PIN) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or empty.");
        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative.");
        if (PIN == null || PIN.isBlank())
            throw new IllegalArgumentException("PIN cannot null or empty");
        this.name = name;
        this.balance = balance;
        this.PIN = PIN;
        this.frozenStatus = false;
        this.sentToday = 0.0;
    }

    public void debit(double amount) throws InsufficientBalanceException {
        if (amount < 0.0)
            throw new IllegalArgumentException("Amount cannot be negative");
        if (amount > this.balance)
            throw new InsufficientBalanceException("Insufficient balance");
        this.balance -= amount;
    }

    public double balance() {
        return this.balance;
    }

    public void credit(double amount) {
        if (amount < 0.0)
            throw new IllegalArgumentException("Amount cannot be negative");
        if (amount == 0.0)
            throw new IllegalArgumentException("Amount cannot be zero");
        this.balance += amount;
    }

    public boolean verifyPin(String PIN) {
        return this.PIN.equals(PIN);
    }

    public void freeze() {
        this.frozenStatus = true;
    }
}
