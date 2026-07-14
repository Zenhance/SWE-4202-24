// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    protected Wallet payer;
    protected Wallet paidTo;
    protected double amount;
    private final String pin;

    public Transaction(Wallet payer, Wallet paidTo, double amount, String pin) throws FrozenAccountException {

        if(payer.isFrozen()){
            throw new FrozenAccountException("is frozen");
        }
        if(!payer.verifyPin(pin)){
            throw new FrozenAccountException("Invalid pin");
        }


        this.payer=payer;
        this.paidTo=paidTo;
        this.amount=amount;
        this.pin=pin;
    }
    public final double getAmount(){
        return amount;
    }

    public abstract double fee();

    protected double payeeCredit(){
        return amount;
    }
    protected abstract void checkPermission() throws OperationNotAllowedException;
    public final void settle() throws TransactionException {
        if (payer.isFrozen()) {
            throw new FrozenAccountException(payer.id() + " is frozen");
        }
        if (!payer.verifyPin(pin)) {
            throw new InvalidPinException("wrong PIN for " + payer.id());
        }
        checkPermission();
        payer.checkDailyLimit(amount);


        payer.debit(amount + fee());
        paidTo.credit(payeeCredit());
        payer.recordSpend(amount);
    }


}
