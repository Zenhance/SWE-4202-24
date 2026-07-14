// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {


      /*public String type;        // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    public double amount;
    public String fromId;
    public String toId;
    public String pin;



    public Transaction(String type, double amount, String fromId, String toId, String pin) {
        if(amount<=0)
            throw new IllegalArgumentException("Transaction needs to be positive");

        this.type = type;
        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }
}        */

    private Wallet payWallet;
private Wallet receiveWallet;
private double amount;
private String pin;


public Transaction(Wallet payWallet,Wallet receiveWallet,double amount,String pin){

    if(payWallet==null)
        throw new IllegalArgumentException("Payer cant be null");
    if(receiveWallet==null)
        throw new IllegalArgumentException("Receiver cant be null");
    if(amount<=0.0)
        throw new IllegalArgumentException("Amount cant be negative");
    if(pin==null||pin.isBlank()||pin.isEmpty())
        throw new IllegalArgumentException("Pin cant be null");
    if(!payWallet.pinVerify(pin))
        throw new IllegalArgumentException("Pin is invalid");

    this.payWallet=payWallet;
    this.receiveWallet=receiveWallet;
    this.amount=amount;
    this.pin=pin;
}

public abstract double fee();
public abstract void settle();
}
