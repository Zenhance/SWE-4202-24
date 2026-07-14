public class Wallet {
    private String id;
    private double balance;
    private String pin;
    private double spentToday;
    private boolean frozen;

    public Wallet(String id, double balance, String pin) {
        if(id==null) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        if(balance<0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if(pin==null) {
            throw new IllegalArgumentException("PIN cannot be empty");
        }

        this.id=id;
        this.balance=balance;
        this.pin=pin;
        this.frozen=false;
        this.spentToday=0.0;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public double getSpentToday() {
        return spentToday;
    }

    public boolean getFrozen() {
        return frozen;
    }

    public void debit(double amount) {
        if(amount<=0) {
            throw new IllegallArgumentException ("Debit amount cannot be negative")
        }
    }
}
