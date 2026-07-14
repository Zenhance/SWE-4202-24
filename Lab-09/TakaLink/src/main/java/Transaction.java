// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    private Wallet from;        // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    private Wallet to;
    private double amount;
//    public String toId;
    private  String pin;

    protected Transaction(Wallet from, Wallet to, double amount,String pin){
        if(from == null | to == null){
            throw new IllegalArgumentException("Wallet can't be null");
        }
        if(amount <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        if(pin == null) {
            throw new IllegalArgumentException("Pin can't be negative");
        }
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pin = pin;
    }
}
