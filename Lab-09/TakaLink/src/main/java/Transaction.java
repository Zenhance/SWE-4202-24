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

    public Transaction(String type, double amount, String fromId, String toId, String pin) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive.");
        }
        if (fromId == null || fromId.isBlank() || toId == null || toId.isBlank()) {
            throw new IllegalArgumentException("Wallet IDs cannot be null or blank.");
        }
        if (pin == null) {
            throw new IllegalArgumentException("PIN cannot be null.");
        }

        this.type = type;
        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }

    public double amount() {
        return this.amount;
    }

    public abstract double fee();


    public void settle() {
    }
}
