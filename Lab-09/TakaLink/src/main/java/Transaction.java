
public abstract class Transaction {
    protected Wallet from;
    protected Wallet to;
    protected double amount;
    protected String pin;

    public Transaction(Wallet from, Wallet to, double amount, String pin) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pin = pin;
        if (from == null || to == null)
            throw new IllegalArgumentException("Wallet cant be null");

        if (amount <= 0)
            throw new IllegalArgumentException("Amount cant be negative.");
        if (pin == null)
            throw new IllegalArgumentException("PIN cant be null");
    }
    public Wallet getFrom(){
        return from;
    }
    public Wallet getTo(){
        return to;
    }
    public double getAmount(){
        return amount;
    }
    public abstract double getFee();
    public abstract String getType();
    protected abstract void moveMoney() throws TransactionException;
    public final void settle() throws TransactionException{

    }


}
