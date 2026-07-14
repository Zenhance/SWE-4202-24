// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
   /* public String type;        // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    public double amount;
    public String fromId;
    public String toId;
    public String pin;

    public Transaction(String type, double amount, String fromId, String toId, String pin) {
        this.type = type;
        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }*/

    private String payingWallet;
    private String receivingWallet;
    private double amount;
    private String PIN;

    public Transaction(String payingWallet, String receivingWallet, double amount, String PIN) {
        if(payingWallet==null||receivingWallet==null||amount<0||PIN==null){
            throw new IllegalArgumentException();
        }else{
            this.payingWallet = payingWallet;
            this.receivingWallet = receivingWallet;
            this.amount = amount;
            this.PIN = PIN;
        }
    }



}
