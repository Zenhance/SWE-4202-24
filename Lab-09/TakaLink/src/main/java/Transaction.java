
public abstract class Transaction {
    protected final Wallet from;
    protected final Wallet to;
    protected final double amount;
    protected final String pin;
    protected Transaction(Wallet from, Wallet to, double amount, String pin) {
        if (from == null ) {
            throw new IllegalArgumentException("The from wallet is null");
        }
        if(to==null){
            throw new IllegalArgumentException("The to wallet is null");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pin = pin;
    }
    public abstract double fee();
    public abstract void checkPermission() throws OperationNotAllowedException;
    protected abstract void moveMoney(double fee) throws InsufficientBalanceException;

    public final void settle() throws TransactionException {
        from.assertNotFrozen();
        from.assertPin(pin);
        checkPermission();
        double fee = fee();
        from.assertWithinDailyLimit(amount);
        moveMoney(fee);
        from.recordSpend(amount);
    }
    public Wallet from() {
        return from;
    }

    public Wallet to() {
        return to;
    }

    public double amount() {
        return amount;

    }
}
