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

    }
}
