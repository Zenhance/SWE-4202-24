// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public class Transaction {
    public String type;        // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    public double amount;
    public Wallet fromId;
    public Wallet toId;
    public String pin;

    public Transaction(String type, double amount, Wallet fromId, Wallet toId, String pin) {
        this.type = type;
        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }

    public void settle() {

    }
}
