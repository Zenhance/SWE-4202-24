// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    private Wallet sender, receiver;
    public double amount;
    public String pin;
    public Transaction(Wallet sender,Wallet receiver, double amount, String pin) {
        this.receiver = receiver;
        this.sender = sender;
        this.amount = amount;
        this.pin = pin;
    }

    public void settle() throws InvalidPinException, FrozenAccountException, InsufficientBalanceException,DailyLimitExceededException {
        if (!sender.verifyPin(pin)) throw new InvalidPinException();
        if(sender.frozen) throw new FrozenAccountException((sender.identity)+"is frozen");
        if(sender.balance()<amount+fee()) throw new InsufficientBalanceException("Not enough balance");
        if(sender.total_sent+amount+fee()> sender.dailylimit)  throw new DailyLimitExceededException();
        sender.debit(amount+fee());
        receiver.credit(amount);
    }

    public double fee() {
        return 0.0;
    }
}
