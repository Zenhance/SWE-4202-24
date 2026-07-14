public class Wallet {

    private String id;
    private double balance;
    private boolean frozen;
    private double spentToday;
    private String pin;

    public Wallet(String id, double balance, String pin) {
        if (id == null) throw new NullPointerException("Must provide Identity");
        if(balance < 0) throw new IllegalArgumentException("Cannot create Account with negative balance");
        if(pin == null) throw new NullPointerException("Must provide pin");

        spentToday = 0;
        this.balance = balance;
        this.id = id;
        this.pin = pin;
    }

    public void debit(double amount) throws InsufficientBalanceException{
        if (amount <= 0) throw new IllegalArgumentException("amount must be positive, got" + amount);
        if (amount > balance) throw new InsufficientBalanceException("balance " + balance + " too low for " + amount);

        spentToday += amount;
        balance -= amount;
    }

    public double balance() {
        return balance;
    }

    public void credit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount must be positive, got" + amount);

        balance += amount;
    }

    public boolean verifyPin(String number) {
        if (pin.equals(number)) return true;
        return false;
    }

    public void freeze() {
        this.frozen = true;
    }
}