// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    private final Wallet from;
    private final Wallet to;
    private final double amount;
    private final String pin;

    public Transaction(Wallet from, Wallet to, double amount, String pin) throws IllegalAccessException {
        if (amount <= 0) {
            throw new IllegalAccessException("Transaction amount must be positive");
        }

        if (pin == null) {
            throw new IllegalAccessException("PIN cannot be null");
        }

        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pin = pin;
    }

    public abstract double getFee();

    public abstract void settle() throws TransactionException;
}
