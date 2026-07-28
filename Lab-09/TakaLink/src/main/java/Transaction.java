
package src.main.java;

public abstract class Transaction {
    protected Wallet from;
    protected Wallet to;
    protected double amount;
    protected String pin;

    public Transaction(Wallet from, Wallet to, double amount, String pin) {
        if(from == null || to == null){
            throw new IllegalArgumentException("From and to cant be null");
        }
        if(amount<=0){
            throw new IllegalArgumentException("Invalid amount");
        }
        if(pin == null){
            throw new IllegalArgumentException("PIN cant be null");
        }
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pin = pin;
    }
    public abstract double fee();
    protected abstract void moveMoney() throws TransactionException;
    public final void settle() throws TransactionException{
        from.checkFrozen();
    if(!from.verifyPin()){
        throw new InvalidPinException("Invalid Pin");
    }
    from.validateOperation(this);
    if (amount > from.getRemainingDailyLimit()) {
        throw new DailyLimitExceededException("Daily limit exceeded");
    }
    if (from.balance() < amount + fee()) {
        throw new InsufficientBalanceException("Insufficient balance");
    }
    moveMoney();
    from.addSpent(amount);

    }
    public Wallet getSender() {
        return from;
    }

    public Wallet getReceiver() {
        return to;
    }

}
