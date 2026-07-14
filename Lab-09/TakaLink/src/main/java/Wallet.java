public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id, String pin, double balance) {
        this.id = id;
        this.pin = pin;
        this.balance = balance;
        this.frozen = false;
        this.spentToday = 0.0;
    }
}
