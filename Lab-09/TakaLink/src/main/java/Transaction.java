// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
//    public String type;        // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
//    public double amount;
//    public String fromId;
//    public String toId;
//    public String pin;

    protected Wallet payingWallet;
    protected Wallet receivingWallet;
    protected double amount;
    private String PIN;

//    public Transaction(String type, double amount, String fromId, String toId, String pin) {
//        this.type = type;
//        this.amount = amount;
//        this.fromId = fromId;
//        this.toId = toId;
//        this.pin = pin;
//    }

    public Transaction(Wallet payingWallet, Wallet receivingWallet, double amount, String PIN) {
        if (payingWallet == null)
            throw new IllegalArgumentException("Payer cannot be null");
        if (receivingWallet == null)
            throw new IllegalArgumentException("Receiver cannot be null");
        if (amount <= 0.0)
            throw new IllegalArgumentException("Amount cannot be negative or zero");
        if (PIN == null || PIN.isBlank() || PIN.isEmpty())
            throw new IllegalArgumentException("PIN cannot be null, empty or blank");
        //InvalidPinException
        if (!payingWallet.verifyPin(PIN))
            throw new IllegalArgumentException("Invalid PIN");
        this.payingWallet = payingWallet;
        this.receivingWallet = receivingWallet;
        this.amount = amount;
        this.PIN = PIN;
    }

    public abstract double fee();

    public abstract void settle() throws InsufficientBalanceException;

    public String getPIN() {
        return PIN;
    }
}
