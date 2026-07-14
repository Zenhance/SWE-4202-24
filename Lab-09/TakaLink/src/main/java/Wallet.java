public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean status;

    public Wallet(String id, double balance, String pin){
        this.id = id;
        this.balance = balance;
        this.pin = pin;
        status = true;
    }

    public void debit(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount cannot be negative");
        if (amount > this.balance)
            return; // InsufficientBalanceException

        this.balance -= amount;
    }



}
