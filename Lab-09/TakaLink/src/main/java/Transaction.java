// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    protected final Wallet fromId;
    protected final Wallet toId;
    protected final double amount;
    protected final String pin;

    public Transaction(Wallet fromId,Wallet toId, double amount, String pin) {
        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }
    public abstract double fee();
    protected abstract void validateSpecificRules()
        throws TransactionException;
    protected abstract void executeMovement()
        throws InsufficientBalanceException;
    public final void settle()
        throws TransactionException{

        if(fromId.isFrozen()){
            throw new FrozenAccountException("Account in frozen");
        }
        validateSpecificRules();

    }

}
