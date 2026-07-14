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
    public String fromId;
    public String toId;
    public String pin;

    public Transaction(String fromId, String toId,double amount, String pin) {
        if(fromId==null){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(toId==null){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(amount<=0){
            throw new IllegalArgumentException("Amount has to be positive");
        }
        if(pin==null){
            throw new IllegalArgumentException("Pin cannot be null");
        }

        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }

    public abstract double fee();

    public abstract void validateOperation() throws OperationNotAllowedException;

    public abstract void moveMoney() throws TransactionException;

    public double getAmount(){
        return amount;
    }

    public Wallet getFromId(){
        return fromId;
    }

    public Wallet getToId(){
        return toId;
    }

    public String getPin(){
        return pin;
    }

    public void settle() throws TransactionException{
    if(fromId.isFrozen()){
        throw new FrozenAccountException();
    }
    if(!fromId.verifyPin(pin)){
        throw new InvalidPinException();
    }
    if(fromId.getSpentToday()+amount>fromId.dailyLimit())
        throw new DailyLimitExceededException();
    if(fromId.getBalance()<amount+fee())
        throw new InsufficientBalanceException();
    moveMoney();
    fromId.addSpent(amount);
    }
}
