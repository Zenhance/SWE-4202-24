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
        if(fromId==null){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(toId==null){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(amount<=0){
            throw new IllegalArgumentException("Amount has to be positive");
        }
        if(pin==null){
            throw new IllegalArgumentException("Pin cannot be null");
        }

        this.type = type;
        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }
}
