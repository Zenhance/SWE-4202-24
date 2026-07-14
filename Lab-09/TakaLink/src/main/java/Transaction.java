// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    String type;
    // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    private double amount;
   public Wallet fromId;
  public   Wallet toId;
    private String pin;

    public Transaction(  Wallet fromId, Wallet toId,double amount,String pin) {
        if (fromId==null||toId==null)
            throw new IllegalArgumentException("Id has to be given");
        if (amount<=0)
            throw new IllegalArgumentException("Amount must be positive");

        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }

    public Transaction(String send, double v, String number, String number1, String number2) {
    }

    public Wallet getFromId() {
        return fromId;
    }

    public Wallet getToId() {
        return toId;
    }

    public double getAmount() {
        return amount;
    }
    protected abstract TransactionType type();

    public final void settle()  throws TransactionException {
        if (fromId.isFrozen()) {
            throw new FrozenAccountException(fromId);
        }
        if (!fromId.verifyPin(pin)) {
            throw new InvalidPinException(fromId);
        }
        if (!fromId.canPay(type())) {
            throw new OperationNotAllowedException(fromId, type());
        }
        if (fromId.remainingDailyLimit() < amount) {
            throw new DailyLimitExceededException(fromId, amount);
        }
        double totalDebit = amount + fee();
        if (fromId.getBalance() < totalDebit) {
            throw new InsufficientBalanceException(fromId, totalDebit);
        }

        // Every precondition has passed -- only now does any money move.
        fromId.debit(totalDebit);
        toId.credit(amount);
        fromId.recordSpend(amount);
    }
    public abstract double fee() ;

}
