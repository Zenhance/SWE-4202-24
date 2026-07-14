public abstract class Wallet {
    private String type;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String type, double balance, String pin, boolean frozen, double spentToday) {
        if(type == null || type.isBlank()) {
            throw new IllegalArgumentException("type is null or blank");
        }
        if(balance < 0) {
            throw new IllegalArgumentException("balance is negative");
        }
        if(pin == null || pin.isBlank()) {
            throw new IllegalArgumentException("pin is null or blank");
        }

        this.type = type;
        this.balance = balance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = spentToday;
    }

    public String getType() {
        return type;
    }
    public double getBalance() {
        return balance;
    }
    public String getPin() {
        return pin;
    }
    public boolean isFrozen() {
        return frozen;
    }
    public double getSpentToday() {
        return spentToday;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }
    public void setSpentToday(double spentToday) {
        this.spentToday = spentToday;
    }

    public abstract double cashOut(double amount);
    public abstract double sendMoney(double amount);
    public abstract double receiveMoney(double amount);

    public double debit(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("amount is negative");
        }
        balance -= amount;
    }

    public double credit(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("amount is negative");
        }
        balance += amount;
    }

}
