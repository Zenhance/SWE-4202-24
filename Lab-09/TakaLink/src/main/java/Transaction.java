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
    protected double amount;
    private Wallet from;
    private Wallet to;
    private String pin;

    public Transaction(Wallet from, Wallet to, double amount, String pin) {
        if (from == null) throw new NullPointerException("Sender cannot be null");
        if (to == null) throw new NullPointerException("Receiver cannot be null");
        if (amount <= 0) throw new IllegalArgumentException("amount cannot be non positive");
        if (pin == null) throw new NullPointerException("Must provide pin");

        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pin = pin;
    }

    public abstract double fee();

    public abstract void settle();
}
