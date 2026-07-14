// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    private final TransactionType type;
    private final double amount;
    private final Wallet fromId;
    private final Wallet toId;
    private final String pin;

    protected Transaction(TransactionType type, double amount, Wallet fromId, Wallet toId, String pin) {
        if (fromId == null || toId == null) {
            throw new IllegalArgumentException(
                    "Wallet cannot be null"
            );
        }
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be positive"
            );
        }
        if (pin == null) {
            throw new IllegalArgumentException(
                    "PIN cannot be null"
            );
        }


        this.type = type;
        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }
    protected TransactionType type() {
        return type;
    }

    protected double amount() {
        return amount;
    }
    protected Wallet fromId() {
        return fromId;
    }
    protected Wallet toId() {
        return toId;
    }
    public double amount() {
        return amount;
    }

    protected TransactionType type() {
        return type;
    }
    public abstract double fee();
    protected abstract void validateSpecific()
            throws TransactionException;

    protected abstract void moveMoney()
            throws TransactionException;

    public final void settle()
            throws TransactionException {

        if (!fromId.verifyPin(pin)) {
            throw new InvalidPinException();
        }

        if (fromId.isFrozen()) {
            throw new FrozenAccountException();
        }

        if (!fromId.allows(type)) {
            throw new OperationNotAllowedException();
        }

        validateSpecific();

        if (amount > fromId.remainingDailyLimit()) {
            throw new DailyLimitExceededException();
        }

        if (fromId.balance() < amount + fee()) {
            throw new InsufficientBalanceException();
        }

        moveMoney();

        fromId.recordSpend(amount);
    }
}
