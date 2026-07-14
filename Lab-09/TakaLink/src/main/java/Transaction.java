// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    public String type;        // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    public double amount;
    public String fromId;
    public String toId;
    public String pin;

    public Transaction(String fromId, String toId, double amount, String pin) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Transaction always positive");
        }

        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }

    public abstract double fee();
}
