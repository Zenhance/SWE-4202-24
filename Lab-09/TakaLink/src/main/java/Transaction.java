// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    protected Wallet from;
    protected Wallet to;
    protected double amount;
    private String pin;

    protected Transaction(Wallet from, Wallet to, double amount, String pin) {
        this.from=from;
        this.to=to;
        this.amount=amount;
        this.pin=pin;
    }

    public double amount() {
        return amount;
    }

    public abstract double fee();

    public abstract boolean isPayerAllowed();

    protected void validateCounterparty() {

    }
}
