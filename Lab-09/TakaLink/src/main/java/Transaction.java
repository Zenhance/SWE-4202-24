// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public class Transaction {
    private Wallet sender, receiver;
    public double amount;
    public String pin;
    public Transaction(Wallet sender,Wallet receiver, double amount, String pin) {
        
        this.receiver = receiver;
        this.sender = sender;
        this.amount = amount;
    }

    public void settle() {
    }

    public double fee() {
    }
}
