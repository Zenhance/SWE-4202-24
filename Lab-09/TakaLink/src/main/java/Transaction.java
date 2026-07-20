
public abstract class Transaction {
    protected final Wallet fromId;
    protected final Wallet toId;
    protected final double amount;
    protected final String pin;
    public Transaction(Wallet fromId, Wallet toId, double amount, String pin) {
        if (fromId==null||toId==null) throw new IllegalArgumentException("Wallets cannot be null");
        if (amount<=0) throw new IllegalArgumentException("Amount must be positive");

        this.fromId=fromId;
        this.toId=toId;
        this.amount=amount;
        this.pin=pin;
    }
    public double getAmount() { return this.amount; }
    public abstract double fee();
    protected abstract void validateSpecifics() throws OperationNotAllowedException;
    public void settle() throws TransactionException {
    }
}