// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
    private Wallet sender;
    private Wallet reciever;
    private double amount;
    private String pin;

    public Transaction(Wallet sender, Wallet reciever, double amount, String pin) {
        if(sender==null || reciever==null)
            throw new IllegalArgumentException("Wallet can not be null");
        if(amount<0)
            throw new IllegalArgumentException("Amount can not be negative");
        if(pin==null || pin.isBlank())
            throw new IllegalArgumentException("Pin can not be null");

        this.sender = sender;
        this.reciever = reciever;
        this.amount = amount;
        this.pin = pin;
    }
    public abstract double fee();
    public abstract void validOperation() throws TransactionException;
    public abstract void moveMoney() throws TransactionException;

    public Wallet getSender() {
        return sender;
    }
    public Wallet getReciever() {
        return reciever;
    }
    public double getAmount() {
        return amount;
    }
    public String getPin() {
        return pin;
    }

    public void settle() throws TransactionException {
        if(!sender.verifyPin(getPin()))
            throw new InvalidPinException();

        sender.checkFrozen();
        validOperation();

        double fee = fee();
        if(sender.remainingLimit()< amount)
            throw new DailyLimitExceedException();
        if(sender.getBalance()>amount+fee)
            throw new InsufficientBalanceException();

        moveMoney();
        sender.addSpent(amount);
    }
}
