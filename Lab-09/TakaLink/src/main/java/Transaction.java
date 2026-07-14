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

    public Transaction() {
        this.from = from;
        to = wallet;
        this.amount = amount;
        this.pin = pin;
    }

    public Transaction(Wallet from, Wallet wallet, double amount, String pin) {

        this.from = from;
        to = wallet;
        this.amount = amount;
        this.pin = pin;
    }

    public Wallet getFrom() {
        return from;
    }

    public Wallet getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public String getPin() {
        return pin;
    }

    public abstract double getFee();

    public abstract void settle() throws TransactionException;
}
