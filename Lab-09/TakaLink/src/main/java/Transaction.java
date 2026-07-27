public abstract class Transaction {
    protected Wallet from;
    protected Wallet to;
    protected double amount;
    protected String pin;
    public Transaction(Wallet from,Wallet to,double amount,String pin) {
        if (from==null || to==null) {
            throw new IllegalArgumentException("Wallet cannot be null.");
        }
        if (amount<=0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (pin==null) {
            throw new IllegalArgumentException("PIN cannot be null.");
        }

        this.from =from;
        this.to= to;
        this.amount=amount;
        this.pin=pin;
    }
    public Wallet getFrom() {
        return from;
    }
    public Wallet getTo() {
        return to;
    }
    public double getAmount() {
        return amount;
    }
}
