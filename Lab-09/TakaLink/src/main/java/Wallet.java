public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen = false;
    private double sentAmount = 0.0;

    public Wallet(String id, double balance, String pin) {
        if(balance < 0) {
            throw new IllegalArgumentException("Balance can't be negative");
        }
        if(pin == null) {
            throw new IllegalArgumentException("Pin can't be null");
        }
        this.id = id;
        this.balance = balance;
        this.pin = pin;
    }

    public double balance() {
        return this.balance;
    }

    public void debit(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Debit can't be negative");
        }
        this.balance -= amount;
    }








}
