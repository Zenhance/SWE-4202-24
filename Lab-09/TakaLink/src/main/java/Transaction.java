public abstract class Transaction {
    protected final Wallet sender;
    protected final Wallet receiver;
    protected final double amount;
    protected final String pin;

    public Transaction(Wallet sender, Wallet receiver, double amount, String pin) {
        if (sender == null || receiver == null) throw new IllegalArgumentException();
        if (amount <= 0) throw new IllegalArgumentException();
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.pin = pin;
    }

    public abstract double fee();

    protected void validate() throws TransactionException { }

    protected abstract void execute() throws TransactionException;
}
