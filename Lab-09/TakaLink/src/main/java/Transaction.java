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

    public Transaction(TransactionType type, double amount, Wallet fromId, Wallet toId, String pin)) {
        this.type = type;
        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }

}
