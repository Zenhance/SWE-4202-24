// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    protected String type;        // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    protected double amount;
    protected String fromId;
    protected String toId;
    protected String pin;

    public Transaction(String type, double amount, String fromId, String toId, String pin) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount must be a positive number.");
        }
        this.type = type;
        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }
}
