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
    //public String type;        // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    protected double amount;
    //public String fromId;
    //public String toId;
    protected String pin;

    public Transaction(Wallet from,Wallet to,double amount,String pin) {
        if(from==null)
            throw new IllegalArgumentException();

        if(to==null)
            throw new IllegalArgumentException();

        if(amount<=0)
            throw new IllegalArgumentException();
        this.from= from;
        this.amount = amount;
        this.to = to;
        this.pin = pin;
    }

    public double amount(){
        return amount;
    }

    public abstract double fee();

    protected abstract void validate()
        throws TransactionException;

    protected abstract void transfer()
        throws TransactionException;

    public final void settle()throws TransactionException{
        validate();
        transfer();
        from.addSpent(amount);
    }
}
