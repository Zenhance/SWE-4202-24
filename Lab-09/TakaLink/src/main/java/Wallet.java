public abstract class Wallet {
    private final String name;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String name, double balance, String pin) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("name must not be null or blank");

        if (balance < 0) throw new IllegalArgumentException("balance must not be negative");

        if (pin == null) throw new IllegalArgumentException("pin must not be null");

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
}
