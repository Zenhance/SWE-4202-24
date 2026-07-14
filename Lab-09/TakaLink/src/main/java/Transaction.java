// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

import javax.naming.OperationNotSupportedException;

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    protected final Wallet from;
    protected final Wallet to;
    protected final double amount;
    protected final String pin;
    protected Transaction(Wallet from, Wallet to, double amount, String pin) {
        if(from == null || to == null){
            throw new IllegalArgumentException("Transaction requires two real wallets");
        }
        if(amount<=0){
            throw new IllegalArgumentException("transaction amount must be positive");
        }
        this.from=from;
        this.to=to;
        this.amount=amount;
        this.pin=pin;
    }

    public final double amount(){
        return amount;
    }

    public abstract double fee();

    protected abstract TransactionKind Kind();

    protected double recipientCredit(){
        return amount;
    }

    public final void settle() throws TransactionException{
        if(from.isFrozen()){
            throw new FrozenAccountException(from.id());
        }
        if(!from.verifyPin(pin)){
            throw new InvalidPinException(from.id());
        }
        if(!from.canBePayerOf(kind())){
            throw new OperationNotAllowedException(from.id(), kind(), "payer");
        }
        if(!to.canBeRecipientOf(kind())){
            throw new OperationNotAllowedException(to.id(), kind(), "recipient");
        }
        if(amount>from.remainingDailyLimit()){
            throw new DailyLimitExceededException(from.id(), amount, from.remainingDailyLimit());
        }


        double totalDebit = amount + fee();
        from.debit(totalDebit);
        to.credit(recipientCredit());
        from.recordSpend(amount);
    }
}
