public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen = false;
    private double SpentToday = 0;

    public Wallet(String id, double balance, String pin) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("invalid");
        if (pin == null) throw new IllegalArgumentException("invalid");
        if (balance < 0) throw new IllegalArgumentException("invalid");
        this.id = id;
        this.balance = balance;
        this.pin = pin;
    }
    public void debit(double amount) throws InsufficientBalanceException {
        if (amount<=0) throw new IllegalArgumentException("Debit must be positive");
        if (this.balance<amount) throw new InsufficientBalanceException();
        this.balance-=amount;
    }
    public void credit(double amount) {
        if (amount<=0) throw new IllegalArgumentException("Credit must be positive");
        this.balance+=amount;
    }
    public double balance() { return this.balance; }
    public boolean verifyPin(String attempt) { return this.pin.equals(attempt); }
    public void freeze() { this.frozen=true; }
    public boolean isFrozen() { return this.frozen; }

}