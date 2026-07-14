// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public class Transaction {
           // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    public double amount;
    public String fromId;
    public String toId;
    public String pin;

    public Transaction(String fromId, String toId, double amount, String pin) {

        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }

    public double getAmount() {
        return amount;
    }

    public String getFromId() {
        return fromId;
    }

    public String getPin() {

        return pin;
    }

    public String getToId() {
        return toId;
    }
}
