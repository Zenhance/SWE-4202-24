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


private Wallet paywallet;
private Wallet receivewallet;
private double amount;
private String pin;


public Transaction(Wallet paywallet,Wallet receivewallet,double amount,String pin){



    this.paywallet=paywallet;
    this.receivewallet=receivewallet;
    this.amount=amount;
    this.pin=pin;
}
}
