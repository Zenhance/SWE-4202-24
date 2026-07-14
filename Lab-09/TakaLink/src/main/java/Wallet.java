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