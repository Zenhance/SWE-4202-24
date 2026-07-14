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

}