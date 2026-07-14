public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id, String pin, double openingBalance) {
        this.id = id;
        this.pin = pin;
        this.balance = openingBalance;
        this.frozen = false;
        this.spentToday = 0.0;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public double getSpentToday() {
        return spentToday;
    }

}
