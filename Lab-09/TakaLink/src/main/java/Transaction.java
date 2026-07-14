// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    protected final Wallet from;
    protected final Wallet to;
    protected final double amount;
    protected final String pin;

    protected final Transaction(Wallet from, Wallet to, double amount, String pin) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pin = pin;

        if (from == null || to == null) throw new IllegalArgumentException("from/to must not be null");

        if (amount <= 0) throw new IllegalArgumentException("amount must be positive");

        if (pin == null) throw new IllegalArgumentException("pin must not be null");
    }
    public double amount() {
        return amount;
    }
    public abstract double fee();
    protected double debitAmount() {
        return amount + fee();
    }
    protected double creditAmount() {
        return amount;
    }
    protected void validateOperation() throws OperationNotAllowedException {}
    protected void validateLimit() throws DailyLimitExceededException {}
    protected void onSettled() {}
    public final void settle() throws TransactionException {
        validateOperation();
    }
    if (from.isFrozen()) throw new FrozenAccountException(from.name() + " is frozen");
    if (!from.verifyPin(pin)) throw new InvalidPinException("wrong pin for " + from.name());
    validateLimit();
    double debit = debitAmount();
    if (debit > from.balance())
        throw new InsufficientBalanceException(from.name() + " has " + from.balance() + " but needs " + debit);
    try{
        from.debit(debit);
    }catch (InsufficientBalanceException alreadyChecked){
        throw alreadyChecked;
    }
}
