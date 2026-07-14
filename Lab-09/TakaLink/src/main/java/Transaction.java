public abstract class Transaction {
    protected final Wallet from;
    protected final Wallet to;
    protected final double amount;
    protected final String offeredPin;

    protected Transaction(Wallet from, Wallet to, double amount, String offeredPin) {
        if (from == null || to == null) throw new IllegalArgumentException("Wallets must not be null");
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (offeredPin == null) throw new IllegalArgumentException("PIN must not be null");
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.offeredPin = offeredPin;
    }

    public abstract double fee();


    protected abstract boolean operationAllowed();

    protected abstract void performTransfer(double totalDebit) throws TransactionException;
}

