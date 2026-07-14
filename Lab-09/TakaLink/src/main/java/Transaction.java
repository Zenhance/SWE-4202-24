// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {


    protected String type;        // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    protected double amount;
    protected Wallet fromId;
    protected Wallet toId;
    protected String pin;



    public Transaction(Wallet fromId, Wallet toId, double amount, String pin)
    {
        if(fromId==null)
            throw new IllegalArgumentException("Id can not be null");
        if(toId==null)
            throw new IllegalArgumentException("Id can not be null");
        if(amount<=0)
            throw new IllegalArgumentException("Amount has to be positive");
        if(pin==null)
            throw new IllegalArgumentException("Pin can not be null");
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
        this.pin = pin;
    }

/* private Wallet payWallet;
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
} */

public abstract double fee();



