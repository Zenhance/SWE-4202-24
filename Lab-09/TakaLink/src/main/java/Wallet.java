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
}