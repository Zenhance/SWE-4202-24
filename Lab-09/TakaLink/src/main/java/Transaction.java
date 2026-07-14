// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    private Wallet payingWallet;
    private Wallet receivingWallet;
    private double amount;
    private String PIN;

    public Transaction(Wallet payingWallet, Wallet receivingWallet,double amount, String PIN) {
        if(payingWallet == null)
            throw new IllegalArgumentException("Paying amount can not be null");
        if(receivingWallet == null)
            throw new IllegalArgumentException("Receiving amount can not be null");
        if(amount<=0.0)
            throw new IllegalArgumentException("amount cant be zero or negative");
        if(PIN == null || PIN.isBlank())
            throw new IllegalArgumentException("PIN cant be null or blank");
        if(payingWallet.verifyPin(PIN)==false){
            throw new IllegalArgumentException("Invalid Pin");
        }
        this.receivingWallet = receivingWallet;
        this.payingWallet = payingWallet;
        this.amount = amount;
        this.PIN = PIN;
    }
    public abstract double fee();

    public abstract void settle();

}
