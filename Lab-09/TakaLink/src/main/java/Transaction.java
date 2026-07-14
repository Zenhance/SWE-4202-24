// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {

    public double amount;
    public String pin;
    public boolean settled = false;
    Wallet a;
    Wallet b;

    public Transaction(Wallet a, Wallet b, double amount, String pin){

        if (a == null || b == null || amount <= 0)
            throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.amount = amount;
        this.pin = pin;
    }

    public abstract double fee();

    public void settle() throws Exception{
        double out = amount + fee();
        if(a.verifyPin(pin) == false)
            throw new InvalidPinException("Invalid Pin :/");
        if(a.balance() < out)
            throw new InsufficientBalanceException("Insufficient Balance :(");
        if(a.isFrozen() || b.isFrozen())
            throw new FrozenAccountException("Account Frozen");

        settled = true;
        SettlementReport.settleCount++;
        SettlementReport.moved++;

    }


}
