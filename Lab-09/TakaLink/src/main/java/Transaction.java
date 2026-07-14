// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public class Transaction {
    private Wallet sender;
    private Wallet receiver;
    protected double transactionAmount;
    private String senderPin;
    private double cost;


    public Transaction(Wallet sender, Wallet receiver, double transactionAmount, String senderPin) {
        this.sender = sender;
        this.receiver = receiver;
        this.transactionAmount = transactionAmount;
        this.senderPin = senderPin;

    }

    public void settle() {

    }




}

