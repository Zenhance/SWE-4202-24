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
    public abstract double getFee();
    protected abstract void moveMoney() throws TransactionException;
    public final void settle() throws TransactionException {
        if (from.isFrozen()) {
            throw new FrozenAccountException();
        }
        if (!from.verifyPin(pin)) {
            throw new WrongPinException();
        }
        if (!from.canPerform(this)) {
            throw new OperationNotAllowedException();
        }
        if (from.getSpentToday()+amount>from.getDailyLimit()) {
            throw new DailyLimitExceededException();
        }
        double total=amount+getFee();
        if (from.getBalance()<total) {
            throw new InsufficientBalanceException();
        }
        from.debit(total);
        moveMoney();
        from.addSpent(amount);
    }
}
}
